
import commands.CommandByTypeServer
import exeption.ArgumentCountError
import exeption.ArgumentError
import exeption.ScriptExecutionError
import request.Request
import response.ResponseStatus
import scanners.MainScanner
import scanners.MyScanners
import java.util.Arrays
import java.util.concurrent.ExecutorService
import kotlin.system.exitProcess

class ServerConsole(private val responseThreadPool: ExecutorService, private val requestProcessor: RequestProcessor) {
    private var mainScanner: MyScanners = MainScanner()
    private val commandsType = CommandByTypeServer()

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

    private fun runCommand(userMessages: String) {
        val messages = userMessages.split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        if (userMessages.isEmpty()) {
            System.err.println("Пустая команда! Введите help для получения списка команд.")
            return
        }
        val commandString = messages[0]
        val argument = if ((messages.size > 1)) Arrays.copyOfRange(messages, 1, messages.size) else arrayOf()
        when (commandString) {
            "exit" -> exitProcess(0)
            else -> {
                val commandType = commandsType.getTypeCommand(commandString)
                if (commandType == null) {
                    System.err.println("Неверная команда! Введите help для получения списка команд.")
                    return
                }
                val request = Request(commandType, commandType.maker.make(argument, mainScanner))
                responseThreadPool.execute {
                    val response = requestProcessor.process(request, 0)
                    if (response.status == ResponseStatus.Successfully) {
                        println(response.message)
                    } else {
                        System.err.println(response)
                    }
                }
            }
        }
    }
}
