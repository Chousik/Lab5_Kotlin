package org.chousik.handlers

import lombok.Getter
import org.chousik.collection.MusicBand
import org.chousik.commands.ACommand
import org.chousik.exception.ArgumentCountError
import org.chousik.exception.ArgumentError
import org.chousik.exception.InvalidCommandError
import org.chousik.exception.ScriptExecutionError
import java.io.File
import java.io.FileNotFoundException
import java.util.*

class RunHandler(collectionM: ICollectionController<MusicBand>, commandM: CommandHandler) {
    private val collectionM: ICollectionController<MusicBand> = collectionM
    private val commandHandler = commandM

    /**
     * Метод для запуска прогрммы в режиме консольной работы
     */
    fun consoleRun() {
        while (true) try {
            print(System.getProperty("user.name") + "> ")
            val Messages = mainScaner.nextLine()
            runCommand(Messages)
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

    /**
     * Метод для запуска программы в режиме скрипта
     *
     * @param fileName имя файла
     * @throws ScriptExecutionError если произошла ошибка выполнения скрипта
     */
    @Throws(ScriptExecutionError::class)
    fun scriptsRun(fileName: String?) {
        val lastScraner: Scanner = getMainScaner()
        isScript = true
        try {
            mainScaner = Scanner(File(fileName))
            while (mainScaner.hasNext()) {
                val messages = mainScaner.nextLine()
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
            mainScaner = lastScraner
            isScript = false
        }
    }
    /**
     * Метод для поиска и выполнения команды
     *
     * @param userMessges сообщение пользователя
     * @throws InvalidCommandError  если команда неверная
     * @throws ArgumentCountError   если неверное количество аргументов
     * @throws ScriptExecutionError если произошла ошибка выполнения скрипта
     * @throws ArgumentError        если аргумент неверный
     */
    @Throws(InvalidCommandError::class, ArgumentCountError::class, ScriptExecutionError::class, ArgumentError::class)
    fun runCommand(userMessges: String) {
        val messages = userMessges.split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val commandString = messages[0]
        val argument = if ((messages.size > 1)) Arrays.copyOfRange(messages, 1, messages.size) else arrayOf()
        val command: ACommand? = commandHandler.getCommands()[commandString]
        if (command == null) {
            System.err.println("Команда не может быть пустой")
            return
        }
        command.execute(argument)
    }

    companion object {
        private var mainScaner = Scanner(System.`in`)
        private var isScript = false

        fun mode(): Boolean {
            return isScript
        }
        fun getMainScaner(): Scanner{
            return mainScaner;
        }
    }
}