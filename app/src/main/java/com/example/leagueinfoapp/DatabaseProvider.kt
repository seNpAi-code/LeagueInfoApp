package com.example.leagueinfoapp
import android.content.Context
import androidx.room.Room

object DbProvider {


    fun getDatabase(context: Context): AppDatabase {

            val db = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "football.db"
            ).build()

        return db
    }
}
