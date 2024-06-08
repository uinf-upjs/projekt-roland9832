package com.example.guesstheword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController

class LetterFragment : Fragment() {
    private var triesCount = 0

    private var editText: EditText? = null
    private var triesTextView: TextView? = null
    private var checkAnswerButton: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_letter, container, false)

        editText = rootView.findViewById(R.id.editTextText2)
        triesTextView = rootView.findViewById(R.id.textView2)
        checkAnswerButton = rootView.findViewById<Button>(R.id.guess_button)

        checkAnswerButton.setOnClickListener(View.OnClickListener { checkAnswerAndNavigate() })

        return rootView
    }

    private fun checkAnswerAndNavigate() {
        val userAnswer = editText!!.text.toString().trim { it <= ' ' }
        if (userAnswer.equals(CORRECT_ANSWER, ignoreCase = true)) {
            navigateToAlphabetFragment(userAnswer)
        } else {
            updateTriesCount()
        }
    }

    private fun navigateToAlphabetFragment(userAnswer: String) {
        val bundle = Bundle()
        bundle.putString("userAnswer", userAnswer)
        findNavController(requireView()).navigate(
            R.id.action_letterFragment_to_alphabetFragment,
            bundle
        )
    }

    private fun updateTriesCount() {
        triesCount++
        triesTextView!!.text = "Tries$triesCount"
    }

    companion object {
        private const val CORRECT_ANSWER = "key"
    }
}