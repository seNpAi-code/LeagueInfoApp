import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clubs")
data class ClubEntity(
    @PrimaryKey val idTeam: String,
    val strTeam: String,
    val strTeamBadge: String,
    val strLeague: String,
    val strStadium: String
)
