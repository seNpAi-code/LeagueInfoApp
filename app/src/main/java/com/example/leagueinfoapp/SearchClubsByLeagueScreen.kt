import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.media3.database.DatabaseProvider
import androidx.navigation.NavController
import androidx.room.Room
import coil.compose.rememberImagePainter

@Composable
fun SearchClubsByLeagueScreen(navController: NavController, clubViewModel: ClubViewModel = viewModel()) {
    var leagueName by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current
    val db = Room.databaseBuilder(context, AppDatabase::class.java, "football.db").build()
    val clubs by clubViewModel.searchResults

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = leagueName,
            onValueChange = { leagueName = it },
            label = { Text("League Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            clubViewModel.searchClubs(leagueName)
        }) {
            Text("Retrieve Clubs")
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(clubs) { club ->
                Column {
                    Text(club.strTeam)
                    Image(
                        painter = rememberImagePainter(club.strTeamBadge),
                        contentDescription = null,
                        modifier = Modifier.size(100.dp),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            clubViewModel.saveClubsToDB(clubs)
            Toast.makeText(context, "Clubs saved to DB", Toast.LENGTH_SHORT).show()
        }) {
            Text("Save Clubs to Database")
        }
    }
}
