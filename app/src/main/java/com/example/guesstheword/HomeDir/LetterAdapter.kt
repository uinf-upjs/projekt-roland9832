package com.example.guesstheword.HomeDir


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.guesstheword.R


class LetterAdapter(private val onClick: (String) -> Unit) : RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {

    private val letters = ('A'..'Z').toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return LetterViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        holder.bind(letters[position])
    }

    override fun getItemCount() = letters.size

    class LetterViewHolder(itemView: View, val onClick: (String) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val letterTextView: TextView = itemView.findViewById(R.id.title)

        fun bind(letter: Char) {
            letterTextView.text = letter.toString()
            itemView.setOnClickListener {
                onClick(letter.toString())
            }
        }
    }
}
