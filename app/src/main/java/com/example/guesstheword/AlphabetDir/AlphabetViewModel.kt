
import androidx.lifecycle.ViewModel
import com.example.guesstheword.Entities.Word
import com.example.guesstheword.Repository.AppRepository
import kotlinx.coroutines.flow.Flow

class AlphabetViewModel(private val repository: AppRepository) : ViewModel() {

    fun getAllLetterWords(letter: Char): Flow<List<Word>> {
        return repository.getAllLetterWords(letter)
    }
}
