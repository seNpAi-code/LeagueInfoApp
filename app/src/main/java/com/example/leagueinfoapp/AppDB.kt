import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [League::class, ClubEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun leagueDao(): LeagueDao
    abstract fun clubDao(): ClubDao

}

