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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navController.navigate("addLeagues") }) {
            Text("Add Leagues to DB")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("searchClubsByLeague") }) {
            Text("Search for Clubs By League")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("searchClubs") }) {
            Text("Search for Clubs")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("searchJerseys") }) {
            Text("Search Jerseys")
        }
    }
}
