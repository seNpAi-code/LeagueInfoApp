package com.example.leagueinfoapp

import AppDatabase
import DbProvider
import LeagueDao
import MainScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.media3.database.DatabaseProvider
import androidx.room.Room
import com.example.leagueinfoapp.ui.theme.LeagueInfoAppTheme

lateinit var db: AppDatabase
lateinit var leagueDao: LeagueDao

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = DbProvider.getDatabase(this)
        leagueDao = db.leagueDao()
        setContent {
            LeagueInfoAppTheme {
                Surface {
                    MainScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LeagueInfoAppTheme {
        MainScreen()
    }
}