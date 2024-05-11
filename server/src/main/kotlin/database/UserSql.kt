package database

import collection.AuthorizationData
import response.CommandResponse
import response.ResponseStatus
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.security.SecureRandom
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class UserSql {
    val connection: Connection

    init {
        Class.forName("org.postgresql.Driver")
        val jdbcUrl = "jdbc:postgresql://localhost:5432/postgres_furry_bot"
        val username = "postgres"
        val password = "postgres"
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password)
        } catch (e: SQLException) {
            throw RuntimeException(e)
        }g
    }

    private fun register(data: AuthorizationData): Pair<CommandResponse, Int> {
        val regSql = "INSERT INTO users(login, password_digest, salt) VALUES (?, ?, ?) RETURNING id"
        val stmt = connection.prepareStatement(regSql)
        try {
            val salt = saltGenerate()
            val md = MessageDigest.getInstance("MD5")
            val passwordByte = md.digest((salt + data.password + paper).toByteArray())
            stmt.setString(1, data.login)
            stmt.setString(2, String(passwordByte, StandardCharsets.UTF_8))
            stmt.setString(3, salt)
            stmt.execute()
            val res = stmt.resultSet
            if (res.next()) {
                return CommandResponse(
                    ResponseStatus.Successfully,
                    "Вы успешно зарегистрированы.",
                ) to stmt.resultSet.getInt("id")
            }
            return CommandResponse(
                ResponseStatus.ExecutionError,
                "Упс, регистраций провалена((. Попробуйте снова!",
            ) to 0
        } catch (e: SQLException) {
            throw RuntimeException(e)
        } finally {
            stmt.close()
        }
    }

    fun login(data: AuthorizationData): Pair<CommandResponse, Int> {
        val loginSql = "SELECT * FROM users WHERE users.login = ?"
        val stmt = connection.prepareStatement(loginSql)
        try {
            stmt.setString(1, data.login)
            stmt.execute()
            if (stmt.resultSet.next()) {
                val res = stmt.resultSet
                val salt = res.getString("salt")
                val pass = res.getString("password_digest")
                val md = MessageDigest.getInstance("MD5")
                val passwordByte = md.digest((salt + data.password + paper).toByteArray())

                if (pass.equals(String(passwordByte, StandardCharsets.UTF_8))) {
                    return CommandResponse(ResponseStatus.Successfully, "Вы успешно вошли.") to res.getInt("id")
                }
                return CommandResponse(ResponseStatus.ExecutionError, "Вы ввели неверный пароль((.") to 0
            }
            return register(data)
        } catch (e: SQLException) {
            throw RuntimeException(e)
        } finally {
            stmt.close()
        }
    }

    private fun saltGenerate(): String {
        val random = SecureRandom()
        val salt = ByteArray(16)
        random.nextBytes(salt)
        return String(salt, StandardCharsets.UTF_8)
    }

    companion object {
        val paper = "x6~a1=7(&BG"
    }
}
