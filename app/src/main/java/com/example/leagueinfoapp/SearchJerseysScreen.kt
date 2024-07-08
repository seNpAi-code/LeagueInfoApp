
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
import androidx.navigation.NavController
import coil.compose.rememberImagePainter

@Composable
fun SearchJerseysScreen(navController: NavController, jerseyViewModel: JerseyViewModel = viewModel()) {
    var searchQuery by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current
    val api = createTheSportsDbApi()
    val searchResults by jerseyViewModel.searchResults

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search Query") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            jerseyViewModel.searchTeamsAndJerseys(api, searchQuery)
        }) {
            Text("Search")
        }
        Spacer(modifier = Modifier.height(16.dp))
//        LazyColumn {
//            items(searchResults) { (team, jerseys) ->
//                Column {
//                    Text(team.strTeam)
//                    jerseys.forEach { jersey ->
//                        Image(
//                            painter = rememberImagePainter(jersey.strEquipment),
//                            contentDescription = null,
//                            modifier = Modifier.size(100.dp),
//                            contentScale = ContentScale.Crop
//                        )
//                        Spacer(modifier = Modifier.height(8.dp))
//                    }
//                }
//                Spacer(modifier = Modifier.height(16.dp))
//            }
//        }
    }
}
