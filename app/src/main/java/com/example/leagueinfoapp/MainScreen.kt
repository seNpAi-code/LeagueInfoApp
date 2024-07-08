import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("addLeagues") {
            val context = LocalContext.current
            val db = DbProvider.getDatabase(context)
            val leagueViewModel = LeagueViewModel(db)
            AddLeaguesScreen(navController, leagueViewModel)
        }
        composable("searchClubsByLeague") {
            val context = LocalContext.current
            val db = DbProvider.getDatabase(context)
            val clubViewModel = ClubViewModel(db)
            SearchClubsByLeagueScreen(navController, clubViewModel)
        }
        composable("searchClubs") {
            val context = LocalContext.current
            val db = DbProvider.getDatabase(context)
            val clubViewModel = ClubViewModel(db)
            SearchClubsScreen(navController, clubViewModel)
        }
        composable("searchJerseys") {
            val jerseyViewModel = JerseyViewModel()
            SearchJerseysScreen(navController, jerseyViewModel)
        }
    }
}
