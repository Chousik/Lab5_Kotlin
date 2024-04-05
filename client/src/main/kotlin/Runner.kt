package org.example

import commands.CommandByType
import exeption.ArgumentCountError
import exeption.ArgumentError
import exeption.InvalidCommandError
import exeption.ScriptExecutionError
import org.chousik.commands.validators.ScriptFileValidator
import request.Request
import response.ResponseStatus
import scanners.FileScanner
import scanners.MainScanner
import scanners.MyScanners
import java.io.File
import java.util.Arrays
import java.util.Stack
import kotlin.system.exitProcess

class Runner {
    private val stack = Stack<MyScanners>()
    private var mainScanner: MyScanners = MainScanner()
    private val commandsType = CommandByType()
    private val udp = ClientUDP()
    private val scriptFileValidator = ScriptFileValidator()
    private val scriptRecursionValid = ScriptFileValidator()

    fun consoleRun() {
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
        if (userMessages.isEmpty()) {
            System.err.println("Пустая команда! Введите help для получения списка команд.")
            return
        }
        val messages = userMessages.split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
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
            else -> {
                val commandType = commandsType.getTypeCommand(commandString)
                if (commandType == null) {
                    System.err.println("Неверная команда! Введите help для получения списка команд.")
                    return
                }
                val request = Request(commandType, commandType.maker.make(argument, mainScanner))
                udp.sendRequest(request)
                val response = udp.readResponse()
                if (response.status == ResponseStatus.Successfully) {
                    println(response.message)
                    return
                }
                System.err.println(response)
            }
        }
    }
}
