import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.guesstheword.AlphabetDir.WordAdapter
import com.example.guesstheword.AppDatabase
import com.example.guesstheword.Entities.Word
import com.example.guesstheword.Repository.AppRepository
import kotlinx.coroutines.launch

class AlphabetFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var wordAdapter: WordAdapter
    private lateinit var appRepository: AppRepository
    private lateinit var letter: String // Assuming you pass the letter to AlphabetFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_alphabet, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        wordAdapter = WordAdapter()
        recyclerView.adapter = wordAdapter

        // Initialize repository
        appRepository = AppRepository(AppDatabase.getDatabase(requireContext(), lifecycleScope))
        lifecycleScope.launch {
            val words = appRepository.getWordsForLetter(letter)
            wordAdapter.submitList(words)
        }

        return view
    }
}