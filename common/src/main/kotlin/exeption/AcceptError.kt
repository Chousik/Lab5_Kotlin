package exeption

class AcceptError(private val id: Int): Exception() {
    override fun toString(): String {
        return "Ошибка доступа к элементу с id = $id"
    }
}