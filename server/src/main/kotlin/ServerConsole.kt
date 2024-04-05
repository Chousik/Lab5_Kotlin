
import commands.CommandByTypeServer
import exeption.ArgumentCountError
import exeption.ArgumentError
import exeption.ScriptExecutionError
import kotlinx.coroutines.channels.Channel
import request.FullRequest
import request.Request
import request.RequestContext
import response.CommandResponse
import response.ResponseStatus
import scanners.MainScanner
import scanners.MyScanners
import java.util.Arrays
import kotlin.system.exitProcess

class ServerConsole(private val requestChanel: Channel<FullRequest>, private val responseChanel: Channel<CommandResponse>) {
    private var mainScanner: MyScanners = MainScanner()
    private val commandsType = CommandByTypeServer()

    suspend fun consoleRun() {
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

    private suspend fun runCommand(userMessages: String) {
        if (userMessages.isEmpty()) {
            System.err.println("Пустая команда! Введите help для получения списка команд.")
            return
        }
        val messages = userMessages.split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
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
                val fullRequest = FullRequest(request, RequestContext.SERVER)
                requestChanel.send(fullRequest)
                val response = responseChanel.receive()
                if (response.status == ResponseStatus.Successfully) {
                    println(response.message)
                    return
                }
                System.err.println(response)
            }
        }
    }
}
