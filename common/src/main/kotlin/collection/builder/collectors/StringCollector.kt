package collection.builder.collectors

import collection.validators.IValidator
import exeption.InvalidDataError
import exeption.ScriptExecutionError
import scanners.FileScanner
import scanners.MyScanners
import kotlin.system.exitProcess

class StringCollector(private val scanner: MyScanners) : ICollector<String, String?> {
    private var isScript = scanner is FileScanner

    override fun ask(
        name: String,
        validator: IValidator<String?>,
    ): String {
        while (true) {
            try {
                if (!isScript) {
                    println("Введите $name")
                    print(System.getProperty("user.name") + "> ")
                }
                val namePerson = scanner.nextLine().trim { it <= ' ' }
                validator.valid(namePerson)
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
