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
        League("4329", "English League Championship", "Soccer", "Championship")
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
