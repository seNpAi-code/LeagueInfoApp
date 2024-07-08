import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LeagueViewModel(private val db: AppDatabase) : ViewModel() {

    fun addLeaguesToDB(leagues: List<League>) {
        viewModelScope.launch {
            db.leagueDao().insertAll(*leagues.toTypedArray())
        }
    }
}
