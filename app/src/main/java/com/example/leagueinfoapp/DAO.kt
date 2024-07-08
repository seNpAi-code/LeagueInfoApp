import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LeagueDao {
    @Insert
    suspend fun insertAll(vararg leagues: League)

    @Query("SELECT * FROM leagues")
    suspend fun getAllLeagues(): List<League>
}

@Dao
interface ClubDao {
    @Insert
    suspend fun insertAll(vararg clubs: ClubEntity)

    @Query("SELECT * FROM clubs WHERE strTeam LIKE '%' || :query || '%' OR strLeague LIKE '%' || :query || '%'")
    suspend fun searchClubs(query: String): List<ClubEntity>
}
