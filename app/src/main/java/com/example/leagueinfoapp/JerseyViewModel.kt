
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class JerseyViewModel : ViewModel() {
    val searchResults = mutableStateOf(emptyList<Pair<Team, List<Equipment>>>())

    fun searchTeamsAndJerseys(api: SportsDbAPI, query: String) {
        viewModelScope.launch {
            val teamsResponse = api.searchTeams(query)
            val results = teamsResponse.teams?.map { team ->
                val equipmentResponse = api.lookupEquipment(team.idTeam)
                team to (equipmentResponse.equipment ?: emptyList())
            } ?: emptyList()
            searchResults.value = results
        }
    }
}
