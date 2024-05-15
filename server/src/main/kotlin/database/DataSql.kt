package database

import collection.Color
import collection.Coordinates
import collection.Country
import collection.Location
import collection.MusicBand
import collection.MusicGenre
import collection.Person
import exeption.AcceptError
import java.sql.Connection
import java.sql.SQLException
import java.sql.Types
import java.util.LinkedList
import java.util.concurrent.atomic.AtomicLong

class DataSql(private val connection: Connection) {
    fun addBand(
        band: MusicBand,
        id: Int,
    ): MusicBand {
        val regSql =
            "INSERT INTO music_band(name, number_of_participants, album_count, genre," +
                "person_name, passport_id, hair_color, nationality, x_coordinates, y_coordinates, x_location," +
                "y_location, z_location, name_location, create_by) VALUES (?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id"
        val stmt = connection.prepareStatement(regSql)
        try {
            var i = 0
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
            val x = AtomicLong()
            val res = stmt.resultSet
            if (res.next()) {
                band.id = res.getInt(1)
                return band
            }
            throw RuntimeException("Ошибка добавления в коллекцию!")
        } catch (e: SQLException) {
            throw RuntimeException(e)
        } finally {
            stmt.close()
        }
    }

    private fun checkAccess(
        id: Int,
        idUser: Int,
    ): Boolean {
        val checkSql = "SELECT * FROM music_band WHERE id = (?)"
        val stmt = connection.prepareStatement(checkSql)
        try {
            stmt.setInt(1, id)
            stmt.execute()
            val res = stmt.resultSet
            if (res.next()) {
                return res.getInt("create_by") == idUser
            }
            return false
        } catch (e: SQLException) {
            throw RuntimeException(e)
        } finally {
            stmt.close()
        }
    }

    fun load(): LinkedList<MusicBand> {
        val selectSql = "SELECT * FROM music_band"
        val stmt = connection.prepareStatement(selectSql)
        try {
            val result = LinkedList<MusicBand>()
            stmt.execute()
            val resultSet = stmt.resultSet
            while (resultSet.next()) {
                val coordinates =
                    Coordinates(
                        resultSet.getFloat("x_coordinates"),
                        resultSet.getFloat("y_coordinates"),
                    )
                val location =
                    Location(
                        resultSet.getDouble("x_location"),
                        resultSet.getInt("y_location"),
                        resultSet.getInt("z_location"),
                        resultSet.getString("name_location"),
                    )
                val person =
                    Person(
                        resultSet.getString("person_name"),
                        resultSet.getString("passport_id"),
                        Color.valueOf(resultSet.getString("hair_color")),
                        Country.valueOf(resultSet.getString("nationality")),
                        location,
                    )
                val band =
                    MusicBand(
                        resultSet.getString("name"),
                        coordinates,
                        resultSet.getLong("number_of_participants"),
                        resultSet.getLong("album_count"),
                        MusicGenre.valueOf(resultSet.getString("genre")),
                        person,
                    )
                band.id = resultSet.getInt("id")
                result.add(band)
            }
            return result
        } catch (e: SQLException) {
            throw RuntimeException(e)
        } finally {
            stmt.close()
        }
    }

    fun removeById(
        id: Int,
        userId: Int,
    ) {
        val loginSql = "DELETE FROM music_band WHERE id = (?)"
        val stmt = connection.prepareStatement(loginSql)
        try {
            if (!checkAccess(id, userId)) {
                throw AcceptError(id)
            }
            stmt.setInt(1, id)
            stmt.execute()
        } catch (e: SQLException) {
            throw RuntimeException(e)
        } finally {
            stmt.close()
        }
    }

    fun updateById(
        id: Int,
        userId: Int,
        band: MusicBand,
    ) {
        val updateSql =
            "UPDATE music_band SET name =(?), number_of_participants =(?), album_count =(?), genre =(?), " +
                "person_name =(?), pasport_id =(?), hair_color =(?), nationality =(?), x_coordinates=(?), " +
                "y_coordinates=(?), " +
                "x_location=(?), y_location=(?), z_location=(?), name_location =(?) WHERE id =(?)"
        val stmt = connection.prepareStatement(updateSql)
        try {
            if (!checkAccess(id, userId)) {
                throw AcceptError(id)
            }
            stmt.setString(1, band.name)
            stmt.setLong(2, band.numberOfParticipants)
            stmt.setLong(2, band.albumsCount)
            stmt.setObject(3, band.genre.toString(), Types.OTHER)
            stmt.setString(4, band.frontMan.name)
            stmt.setString(5, band.frontMan.passportID)
            stmt.setObject(6, band.frontMan.hairColor.toString(), Types.OTHER)
            stmt.setObject(7, band.frontMan.nationality.toString(), Types.OTHER)
            stmt.setFloat(8, band.coordinates.x)
            stmt.setFloat(9, band.coordinates.y)
            stmt.setDouble(10, band.frontMan.location.x)
            stmt.setInt(11, band.frontMan.location.y)
            stmt.setInt(12, band.frontMan.location.z)
            stmt.setString(13, band.frontMan.location.name)
            stmt.setInt(14, id)
            stmt.execute()
        } catch (e: SQLException) {
            throw RuntimeException(e)
        } finally {
            stmt.close()
        }
    }

    fun clear(id: Int): HashSet<Int> {
        val clearSql = "DELETE FROM music_band WHERE create_by = (?) RETURNING id"
        val stmt = connection.prepareStatement(clearSql)
        try {
            val result = HashSet<Int>()
            stmt.setInt(1, id)
            stmt.execute()
            val res = stmt.resultSet
            while (res.next()) {
                result.add(res.getInt("id"))
            }
            return result
        } catch (e: SQLException) {
            throw RuntimeException(e)
        } finally {
            stmt.close()
        }
    }
}
