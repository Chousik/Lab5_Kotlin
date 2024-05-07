package org.example

import collection.AuthorizationData
import commands.CommandByType
import commands.CommandType
import exeption.ArgumentCountError
import exeption.ArgumentError
import exeption.InvalidCommandError
import exeption.ScriptExecutionError
import org.chousik.commands.validators.ScriptFileValidator
import request.Request
import request.RequestClient
import response.ResponseStatus
import scanners.FileScanner
import scanners.MainScanner
import scanners.MyScanners
import java.io.File
import java.net.SocketTimeoutException
import java.util.*
import kotlin.system.exitProcess

class Runner {
    private val stack = Stack<MyScanners>()
    private var mainScanner: MyScanners = MainScanner()
    private val commandsType = CommandByType()
    private val udp = ClientUDP()
    private val scriptFileValidator = ScriptFileValidator()
    private val scriptRecursionValid = ScriptFileValidator()
    private lateinit var authorizationData: AuthorizationData
    fun start(){
        var flag = true
        while (flag){
        authorizationData = CommandType.Authorization.maker.make(arrayOf(), mainScanner) as AuthorizationData
        udp.sendRequest(RequestClient(Request(CommandType.Authorization, null), authorizationData))
        var response = udp.readResponse()
            if (response.status == ResponseStatus.Successfully) {
                flag = false
            }
            println(response.message)
        }
        consoleRun()
    }
    private fun consoleRun() {
        while (true) try {
            print("${System.getProperty("user.name")}> ")
            runCommand(mainScanner.nextLine())
        } catch (e: Exception) {
            when (e) {
                is ArgumentError, is ArgumentCountError, is ScriptExecutionError -> System.err.println(e)
                is NoSuchElementException -> System.err.println("Группы с введенным аргументом не существует.")
                is NumberFormatException -> System.err.println("Аргумент должен быть числом.")
            }
            System.err.println(e)
        }
    }

    private fun scriptsRun(fileName: String) {
        stack.push(mainScanner)
        try {
            mainScanner = FileScanner(File(fileName))
            while (mainScanner.hasNext()) {
                runCommand(mainScanner.nextLine())
            }
        } catch (e: Exception) {
            when (e) {
                is InvalidCommandError, is ArgumentCountError, is ArgumentError -> throw ScriptExecutionError(e.toString())
                else -> System.err.println(e)
            }
        } finally {
            mainScanner = stack.pop()
        }
    }

    private fun runCommand(userMessages: String) {
        val messages = userMessages.split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        if (messages.isEmpty()) {
            System.err.println("Пустая команда! Введите help для получения списка команд.")
            return
        }
        val commandString = messages[0]
        val argument = if ((messages.size > 1)) Arrays.copyOfRange(messages, 1, messages.size) else arrayOf()
        when (commandString) {
            "exit" -> exitProcess(0)
            "execute" -> {
                if (argument.size != 1) {
                    println("Ошибка указания файла")
                    return
                }
                scriptFileValidator.valid(argument[0])
                scriptRecursionValid.valid(argument[0])
                scriptsRun(argument[0])
            }
            "unlogin" -> {
                println("Вы успешно вышли из профиля ${authorizationData.login}")
                start()
            }
            else -> {
                val commandType = commandsType.getTypeCommand(commandString)
                if (commandType == null) {
                    System.err.println("Неверная команда! Введите help для получения списка команд.")
                    return
                }
                var countRequest = 0
                val request = Request(commandType, commandType.maker.make(argument, mainScanner))
                while (countRequest <= 2) {
                    try {
                        udp.sendRequest(RequestClient(request, authorizationData))
                        val response = udp.readResponse()
                        if (response.status == ResponseStatus.Successfully) {
                            println(response.message)
                            return
                        }
                        System.err.println(response)
                        return
                    } catch (e: SocketTimeoutException) {
                        countRequest += 1
                        System.err.println("Ошибка запроса к серверу. Попытка $countRequest")
                        Thread.sleep(10000)
                    }
                }
                System.err.println("Не удалось отправить команду. Попробуйте позже")
            }
        }
    }
}
