package collection.builder.collectors

import collection.validators.IValidator
import exeption.ScriptExecutionError
import scanners.FileScanner
import scanners.MyScanners
import java.util.*
import java.util.function.Function
import kotlin.system.exitProcess

abstract class EnumCollector<T : Enum<*>>(private val scanner: MyScanners) : ICollector<T, String?> {
    private var isScript = scanner is FileScanner
    protected fun askEnum(
        name: String,
        validator: IValidator<String?>,
        method1: Function<String, T>,
        value: String
    ): T? {
        while (true) {
            try {
                if (!isScript) {
                    println("Доступные варианты поля $name: $value")
                    println("Выберите один из вариантов")
                    print(System.getProperty("user.name") + "> ")
                }
                val strValue: String = scanner.nextLine().trim { it <= ' ' }.uppercase(Locale.getDefault())
                if (strValue.isEmpty()) {
                    return null
                }
                validator.valid(strValue)
                return method1.apply(strValue)
            } catch (e: IllegalArgumentException) {
                if (isScript) {
                    throw ScriptExecutionError("Введено некоренное значение из списка.")
                }
                println("Введено некоренное значение из списка.")
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