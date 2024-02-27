package org.chousik.collection.builder.collectors

import org.chousik.collection.validators.IValidator
import org.chousik.exception.InvalidDataError
import org.chousik.exception.ScriptExecutionError
import org.chousik.handlers.RunHandler
import java.util.*
import java.util.function.Function
import java.util.function.Supplier

abstract class EnumCollector<T : Enum<*>?> : ICollector<T, String?> {
    private val isScript = RunHandler.mode()
    private val scanner: Scanner

    init {
        this.scanner = RunHandler.getMainScaner()
    }

    @Throws(ScriptExecutionError::class)
    protected fun askEnum(
        name: String,
        validator: IValidator<String?>,
        method1: Function<String?, T>,
        value: String
//        method2: Supplier<String>
    ): T {
        while (true) {
            try {
                if (!isScript) {
                    println("Доступные варианты поля " + name + ": " + value)
                    println("Выберите один из вариантов")
                    print(System.getProperty("user.name") + "> ")
                }
                var strValue: String? = scanner.nextLine().trim { it <= ' ' }.uppercase(Locale.getDefault())
                if (strValue!!.isEmpty()) {
                    strValue = null
                }
                validator.valide(strValue)
                return method1.apply(strValue)
            } catch (e: InvalidDataError) {
                if (isScript) {
                    throw ScriptExecutionError("Введено неккоретное значение из списка.")
                }
                println("Введено неккоретное значение из списка.")
            } catch (e: NullPointerException) {
                if (isScript) {
                    throw ScriptExecutionError("Значение не может быть null")
                }
                println("Значение не может быть null")
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