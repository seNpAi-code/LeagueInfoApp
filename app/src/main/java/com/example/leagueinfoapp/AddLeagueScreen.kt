
package com.example.leagueinfoapp

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.media3.database.DatabaseProvider
import androidx.navigation.NavController
import androidx.room.Room

@Composable
fun AddLeaguesScreen(navController: NavController, leagueViewModel: LeagueViewModel = viewModel()) {
    val context = LocalContext.current
    val db = Room.databaseBuilder(context, AppDatabase::class.java, "football.db").build()
    val leagues = listOf(
        League("4328", "English Premier League", "Soccer", "Premier League, EPL"),
        League("4329", "English League Championship", "Soccer", "Championship"),
        League("4330", "Scottish Premier League", "Soccer", "Scottish Premiership, SPFL"),
        League("4331", "German Bundesliga", "Soccer", "Bundesliga, Fußball-Bundesliga"),
        League("4332", "Italian Serie A", "Soccer", "Serie A"),
        League("4334", "French Ligue 1", "Soccer", "Ligue 1 Conforama"),
        League("4335", "Spanish La Liga", "Soccer", "LaLiga Santander, La Liga"),
        League("4336", "Greek Superleague Greece", "Soccer", ""),
        League("4337", "Dutch Eredivisie", "Soccer", "Eredivisie"),
        League("4338", "Belgian First Division A", "Soccer", "Jupiler Pro League"),
        League("4339", "Turkish Super Lig", "Soccer", "Super Lig"),
        League("4340", "Danish Superliga", "Soccer", ""),
        League("4344", "Portuguese Primeira Liga", "Soccer", "Liga NOS"),
        League("4346", "American Major League Soccer", "Soccer", "MLS, Major League Soccer"),
        League("4347", "Swedish Allsvenskan", "Soccer", "Fotbollsallsvenskan"),
        League("4350", "Mexican Primera League", "Soccer", "Liga MX"),
        League("4351", "Brazilian Serie A", "Soccer", ""),
        League("4354", "Ukrainian Premier League", "Soccer", ""),
        League("4355", "Russian Football Premier League", "Soccer", "Чемпионат России по футболу"),
        League("4356", "Australian A-League", "Soccer", "A-League"),
        League("4358", "Norwegian Eliteserien", "Soccer", "Eliteserien"),
        League("4359", "Chinese Super League", "Soccer", "")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            leagueViewModel.addLeaguesToDB(leagues)
            Toast.makeText(context, "Leagues added to DB", Toast.LENGTH_SHORT).show()
        }) {
            Text("Add Leagues to DB")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("home") }) {
            Text("Back to Home")
        }
    }
}
