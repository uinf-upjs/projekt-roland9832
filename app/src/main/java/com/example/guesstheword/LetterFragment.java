package com.example.guesstheword;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class LetterFragment extends Fragment {

    private static final String CORRECT_ANSWER = "key";
    private int triesCount = 0;

    private EditText editText;
    private TextView triesTextView;
    private Button checkAnswerButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_letter, container, false);

        editText = rootView.findViewById(R.id.editTextText2);
        triesTextView = rootView.findViewById(R.id.textView2);
        checkAnswerButton = rootView.findViewById(R.id.checkAnswerButton);

        checkAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerAndNavigate();
            }
        });

        return rootView;
    }

    private void checkAnswerAndNavigate() {
        String userAnswer = editText.getText().toString().trim();
        if (userAnswer.equalsIgnoreCase(CORRECT_ANSWER)) {
            navigateToAlphabetFragment(userAnswer);
        } else {
            updateTriesCount();
        }
    }

    private void navigateToAlphabetFragment(String userAnswer) {
        Bundle bundle = new Bundle();
        bundle.putString("userAnswer", userAnswer);
        Navigation.findNavController(requireView()).navigate(R.id.action_letterFragment_to_alphabetFragment, bundle);
    }

    private void updateTriesCount() {
        triesCount++;
        triesTextView.setText("Tries" + triesCount);
    }
}


