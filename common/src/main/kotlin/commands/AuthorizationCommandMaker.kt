package commands

import collection.AuthorizationData
import scanners.MyScanners
import java.io.Serializable
import java.nio.charset.StandardCharsets
import java.security.MessageDigest

class AuthorizationCommandMake: MakerArguments<AuthorizationData>(0), Serializable {
    override fun make(arguments: Array<String>, scanner: MyScanners): AuthorizationData {
        var password = ""
        var login = ""
        var flag = true
        while (flag) {
            println("Введите ваш логин")
            login = scanner.nextLine()
            if (login.isBlank()){
                println("Логин не может быть пустым!")
                continue
            }
            flag = false
        }
        flag = true
        while (flag) {
            println("Введите ваш пароль")
            password = scanner.nextLine()
            if (password.isBlank()){
                println("Пароль не может быть пустым!")
                continue
            }
            flag = false
        }
        val md = MessageDigest.getInstance("MD5")
        val passwordByte = md.digest(password.toByteArray())
        return AuthorizationData(login, String(passwordByte, StandardCharsets.UTF_8))
    }
}