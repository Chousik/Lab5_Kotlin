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
import java.io.FileNotFoundException
import java.util.*
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
            } catch (e: InvalidCommandError) {
                System.err.println(e)
            } catch (e: ArgumentCountError) {
                System.err.println(e)
            } catch (e: ScriptExecutionError) {
                System.err.println(e)
            } catch (e: ArgumentError) {
                System.err.println(e)
            } catch (e: NoSuchElementException) {
                System.err.println("Группы с введенным аргументом не существует.")
            } catch (e: NumberFormatException){
                System.err.println("Аргумент должен быть числом.")
            }
        }

        fun scriptsRun(fileName: String) {
            stack.push(mainScanner)
            try {
                mainScanner = FileScanner(File(fileName))
                while (mainScanner.hasNext()) {
                    runCommand(mainScanner.nextLine())
                }
            } catch (e: InvalidCommandError) {
                throw ScriptExecutionError(e.toString())
            } catch (e: ArgumentCountError) {
                throw ScriptExecutionError(e.toString())
            } catch (e: ArgumentError) {
                throw ScriptExecutionError(e.toString())
            } catch (e: FileNotFoundException) {
                System.err.println(e)
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
            when (commandString){
                "exit" -> exitProcess(0)
                "execute" -> {
                    if (argument.size!=1){
                        println("Ошибка указания файла")
                        return
                    }
                    scriptFileValidator.valid(argument[0])
                    scriptRecursionValid.valid(argument[0])
                    scriptsRun(argument[0])
                }
                else ->{
                    val commandType = commandsType.getTypeCommand(commandString)
                    if (commandType == null) {
                        System.err.println("Неверная команда! Введите help для получения списка команд.")
                        return
                    }
                    val request = Request(commandType, commandType.maker.make(argument, mainScanner))
                    udp.SendRequest(request)
                    val response = udp.readResponse()
                    if (response.status == ResponseStatus.Successfully){
                        println(response.message)
                        return
                    }
                    System.err.println(response)
                }
            }
        }

}