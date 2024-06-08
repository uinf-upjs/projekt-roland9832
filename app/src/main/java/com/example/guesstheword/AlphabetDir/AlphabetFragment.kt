package com.example.guesstheword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class AlphabetFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_alphabet, container, false)

        // Retrieve the letter from the arguments
        val letter = arguments?.getString("letter")

        // Display the letter or use it as needed
        val textView = view.findViewById<TextView>(R.id.textView)
        textView.text = letter

        return view
    }
}
