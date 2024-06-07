package com.example.guesstheword;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.navigation.Navigation;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        Button buttonK = rootView.findViewById(R.id.K);
        buttonK.setOnClickListener(view -> navigateToAlphabetFragment("K"));

        return rootView;
    }

    private void navigateToAlphabetFragment(String buttonId) {
        Bundle bundle = new Bundle();
        bundle.putString("buttonId", buttonId);
        NavController navController = Navigation.findNavController(requireView());
        navController.navigate(R.id.action_homeFragment_to_alphabetFragment, bundle);
    }
}
