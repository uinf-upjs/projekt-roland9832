package com.example.guesstheword.AlphabetDir


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.guesstheword.Entities.Word
import com.example.guesstheword.R

class WordAdapter : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    private var words: List<Word> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.alphabet_layout, parent, false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(words[position])
    }

    override fun getItemCount(): Int {
        return words.size
    }

    fun setWords(words: List<Word>) {
        this.words = words
        notifyDataSetChanged()
    }

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.title)

        fun bind(word: Word) {
            titleTextView.text = if (word.status == "unsolved") "????" else word.correctWord
        }
    }
}
