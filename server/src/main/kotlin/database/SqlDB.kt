package database

import collection.AuthorizationData
import collection.MusicBand
import response.CommandResponse
import response.ResponseStatus
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Types

class SqlDB {
    private var connection: Connection

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
    fun addBand(band: MusicBand, id: Int): MusicBand{
        val regSql = "INSERT INTO music_band(name, number_of_participants, album_count, genre," +
                "person_name, pasport_id, hair_color, nationality, x_coordinates, y_coordinates, x_location," +
                "y_location, z_location, name_location, create_by) VALUES (?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id"
        val stmt = connection.prepareStatement(regSql)
        try {
            var i = 0;
            stmt.setString(++i, band.name)
            stmt.setLong(++i, band.numberOfParticipants)
            stmt.setLong(++i, band.albumsCount)
            stmt.setObject(++i, band.genre.toString(), Types.OTHER)
            stmt.setString(++i, band.frontMan.name)
            stmt.setString(++i, band.frontMan.passportID)
            stmt.setObject(++i, band.frontMan.hairColor.toString(), Types.OTHER)
            stmt.setObject(++i, band.frontMan.nationality.toString(), Types.OTHER)
            stmt.setFloat(++i, band.coordinates.x)
            stmt.setFloat(++i, band.coordinates.y)
            stmt.setDouble(++i, band.frontMan.location.x)
            stmt.setInt(++i, band.frontMan.location.y)
            stmt.setInt(++i, band.frontMan.location.z)
            stmt.setString(++i, band.frontMan.location.name)
            stmt.setInt(++i, id)
            stmt.execute()
            val res = stmt.resultSet
            if (res.next()) {
                band.id = res.getInt(1)
                return band
            }
            throw RuntimeException("Ошибка добавления в коллекцию!")
        }catch (e: SQLException){
            throw RuntimeException(e)
        }finally {
            stmt.close()
        }

    }
    fun clear(id: Int){
        val clearSql = "DELETE "
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