package com.example.guesstheword

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.guesstheword.HomeDir.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tapToPlay: View = findViewById(R.id.twTapToPlay)
        tapToPlay.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.fragment_container_view, HomeFragment())
                addToBackStack(null)
            }
        }
    }
}