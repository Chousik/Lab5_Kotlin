package org.chousik.collection.builder.collectors

import org.chousik.collection.validators.IValidator
import exeption.InvalidDataError
import exeption.ScriptExecutionError
import org.chousik.handlers.RunHandler
import java.util.*

class StringCollector : ICollector<String?, String?> {
    private val isScript = RunHandler.mode()
    private val scanner: Scanner

    init {
        this.scanner = RunHandler.getMainScaner()
    }

    override fun ask(name: String?, validator: IValidator<String?>?): String {
        while (true) {
            try {
                if (!isScript) {
                    println("Введите $name")
                    print(System.getProperty("user.name") + "> ")
                }
                val namePerson = scanner.nextLine().trim { it <= ' ' }
                validator!!.valide(namePerson)
                return namePerson
            } catch (e: InvalidDataError) {
                if (isScript) {
                    throw ScriptExecutionError("Поле $name не может быть пустым.")
                }
                println("Поле $name не может быть пустым.")
            } catch (e: NullPointerException) {
                if (isScript) {
                    throw ScriptExecutionError("Поле $name не может быть null.")
                }
                println("Поле $name не может быть null.")
            } catch (e: NoSuchElementException) {
                if (isScript) {
                    throw ScriptExecutionError("Ошибка во время ввода данных коллекции из файла. Конец файла.")
                }
                println("Не нажимай Ctrl+D((((")
                System.exit(0)
            } catch (e: Exception) {
                if (isScript) {
                    throw ScriptExecutionError("Непридвиденная ошибка")
                }
                println("Непридвиденная ошибка")
                System.exit(0)
            }
        }
    }
}