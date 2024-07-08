import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ClubViewModel(private val db: AppDatabase) : ViewModel() {
    val searchResults = mutableStateOf(emptyList<ClubEntity>())

    fun searchClubs(query: String) {
        viewModelScope.launch {
            searchResults.value = db.clubDao().searchClubs(query)
        }
    }

    fun saveClubsToDB(clubs: List<ClubEntity>) {
        viewModelScope.launch {
            db.clubDao().insertAll(*clubs.toTypedArray())
        }
    }
}
