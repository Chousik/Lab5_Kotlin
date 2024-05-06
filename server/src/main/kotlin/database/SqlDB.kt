package database

import collection.AuthorizationData
import response.CommandResponse
import response.ResponseStatus
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class SqlDB {
    private lateinit var connection: Connection

    init {
        Class.forName("org.postgresql.Driver")
        val jdbcUrl = "jdbc:postgresql://localhost:5432/postgres_furry_bot"
        val username = "postgres"
        val password = "postgres"
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password)
        } catch (e: SQLException) {
            throw RuntimeException(e)
        }
    }

    //    fun getMusicBandByID(id: Int): MusicBand {
//        val getSql = "SELECT * FROM music_band WHERE id = ?"
//        connection.prepareStatement(getSql).use { stmt ->
//            {
//                stmt.setInt(1, id)
//                stmt.execute()
//                val res = stmt.resultSet
//
//            }
//        }
//    }
    private fun register(data: AuthorizationData): CommandResponse {
        val regSql = "INSERT INTO users(login, password_digest) VALUES (?, ?) RETURNING id"
        val stmt = connection.prepareStatement(regSql)
        try {
            stmt.setString(1, data.login);
            stmt.setString(2, data.password);
            stmt.execute()
            val res = stmt.resultSet
            if (res.next()) {
                return CommandResponse(ResponseStatus.Successfully, "Вы успешно зарегистрированы.")
            }
            return CommandResponse(ResponseStatus.ExecutionError, "Упс. Попробуйте снова!")
        }catch (e: SQLException){
            throw RuntimeException(e)
        }finally {
            stmt.close()
        }
    }
    private fun addBand(data: AuthorizationData): CommandResponse {
        val regPerson = "INSERT INTO users(login, password_digest) VALUES (?, ?) RETURNING id"
        val regLocation = "INSERT INTO users(login, password_digest) VALUES (?, ?) RETURNING id"
        val stmt = connection.prepareStatement(regSql)
        try {
            stmt.setString(1, data.login);
            stmt.setString(2, data.password);
            stmt.execute()
            val res = stmt.resultSet
            if (res.next()) {
                return CommandResponse(ResponseStatus.Successfully, "Вы успешно зарегистрированы.")
            }
            return CommandResponse(ResponseStatus.ExecutionError, "Упс. Попробуйте снова!")
        }catch (e: SQLException){
            throw RuntimeException(e)
        }finally {
            stmt.close()
        }
    }
    private fun addLocation(x: Double, y:Int, z: Int, name: String): CommandResponse {
        val regLocation = "INSERT INTO location(x, y, z, name) VALUES (?, ?, ?, ?) RETURNING id"
        val stmt = connection.prepareStatement(regLocation)
        try {

            stmt.setDouble(1, x);
            stmt.setInt(2, y)
            stmt.setInt(3, z)
            stmt.setString(4, name)
            stmt.execute()
            val res = stmt.resultSet
            if (res.next()) {
                return CommandResponse(ResponseStatus.Successfully, "Вы успешно зарегистрированы.")
            }
            return CommandResponse(ResponseStatus.ExecutionError, "Упс. Попробуйте снова!")
        }catch (e: SQLException){
            throw RuntimeException(e)
        }finally {
            stmt.close()
        }
    }
    fun login(data: AuthorizationData): CommandResponse {
        val loginSql = "SELECT * FROM users WHERE users.login = ?"
        val stmt = connection.prepareStatement(loginSql)
        try {
            stmt.setString(1, data.login);
            stmt.execute()
            if (stmt.resultSet.next()) {
                val res = stmt.resultSet
                val pass = res.getString("password_digest")
                if (pass.equals(data.password)){
                    return CommandResponse(ResponseStatus.Successfully, "Вы успешно вошли.")
                }
                return CommandResponse(ResponseStatus.ExecutionError, "Вы ввели неверный пароль((.")
            }
            return register(data)
        }catch (e: SQLException){
            throw RuntimeException(e)
        }finally {
            stmt.close()
        }
    }
}