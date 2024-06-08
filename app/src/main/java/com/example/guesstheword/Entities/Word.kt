package com.example.guesstheword.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "word")
data class Word(
                val letter: Char,
                val correctWord: String,
                val difficulty: Int,
                val status: String,
                val tries: Int,
                val image: String): Serializable{
    @PrimaryKey(autoGenerate = true)
    var wordId: Long = 0
}
