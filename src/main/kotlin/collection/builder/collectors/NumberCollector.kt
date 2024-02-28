package org.chousik.collection.builder.collectors

import org.chousik.collection.validators.IValidator
import exeption.ScriptExecutionError
import org.chousik.handlers.RunHandler
import java.util.*
import java.util.function.Function
import kotlin.system.exitProcess

abstract class NumberCollector<T : Number?> : ICollector<T, T> {
    private val isScript = RunHandler.mode()
    private val scanner: Scanner = RunHandler.getMainScaner()

    protected fun askNumber(name: String, validator: IValidator<T?>, method: Function<String, T>): T {
        while (true) {
            try {
                if (!isScript) {
                    println("Введите $name")
                    print(System.getProperty("user.name") + "> ")
                }
                val string = scanner.nextLine().trim { it <= ' ' }
                val t = method.apply(string)
                validator.valide(t)
                return t
            } catch (e: NumberFormatException) {
                if (isScript) {
                    throw ScriptExecutionError("Поле $name должно быть числом")
                }
                println("Поле $name должно быть числом")
            } catch (e: NullPointerException) {
                if (isScript) {
                    throw ScriptExecutionError("Поле $name не может быть null")
                }
                println("Поле $name не может быть null")
            } catch (e: NoSuchElementException) {
                if (isScript) {
                    throw ScriptExecutionError("Ошибка во время ввода данных коллекции из файла. Конец файла.")
                }
                println("Не нажимай Ctrl+D((((")
                exitProcess(0)
            } catch (e: Exception) {
                if (isScript) {
                    throw ScriptExecutionError("Непредвиденная ошибка")
                }
                println("Непредвиденная ошибка")
                exitProcess(0)
            }
        }
    }
}