package org.chousik.handlers

import org.chousik.commands.ACommand
import exeption.ArgumentCountError
import exeption.ArgumentError
import exeption.InvalidCommandError
import exeption.ScriptExecutionError
import java.io.File
import java.io.FileNotFoundException
import java.util.*

class RunHandler(private val commandHandler: CommandHandler) {
    fun consoleRun() {
        while (true) try {
            print("${System.getProperty("user.name")}> ")
            val userMessages = mainScanner.nextLine()
            runCommand(userMessages)
        } catch (e: InvalidCommandError) {
            System.err.println(e)
        } catch (e: ArgumentCountError) {
            System.err.println(e)
        } catch (e: ScriptExecutionError) {
            System.err.println(e)
        } catch (e: ArgumentError) {
            System.err.println(e)
        }
    }

    fun scriptsRun(fileName: String) {
        val lastScanner: Scanner = getMainScanner()
        isScript = true
        try {
            mainScanner = Scanner(File(fileName))
            while (mainScanner.hasNext()) {
                val messages = mainScanner.nextLine()
                runCommand(messages)
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
            mainScanner = lastScanner
            isScript = false
        }
    }

    private fun runCommand(userMessages: String) {
        if (String.equals("")) {
            System.err.println("Пустая команда! Введите help для получения списка команд.")
            return
        }
        val messages = userMessages.split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val commandString = messages[0]
        val argument = if ((messages.size > 1)) Arrays.copyOfRange(messages, 1, messages.size) else arrayOf()
        val command: ACommand? = commandHandler.getCommands()[commandString]
        if (command == null) {
            System.err.println("Неверная команда! Введите help для получения списка команд.")
            return
        }
        command.execute(argument)
    }

    companion object {
        private var mainScanner = Scanner(System.`in`)
        private var isScript = false

        fun mode(): Boolean {
            return isScript
        }

        fun getMainScanner(): Scanner {
            return mainScanner
        }
    }
}