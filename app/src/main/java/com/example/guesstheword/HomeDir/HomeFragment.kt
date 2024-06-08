package com.example.guesstheword.HomeDir

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.guesstheword.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment(), OnItemClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // RecyclerView setup
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = LetterAdapter { letter ->
            // Navigate to AlphabetFragment with the selected letter using Bundle
            val bundle = Bundle().apply {
                putString("letter", letter)
            }
            findNavController().navigate(R.id.action_homeFragment_to_alphabetFragment, bundle)
        }

        // Setup BottomNavigationView
        val bottomNavigationView =
            view.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    findNavController().navigate(R.id.homeFragment)
                    true
                }

                R.id.profile -> {
                    // Handle profile navigation
                    true
                }

                R.id.settings -> {
                    // Handle settings navigation
                    true
                }

                else -> false
            }
        }

        return view
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        // Not used, but required by OnItemClickListener interface
    }
}
