package com.example.guesstheword.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import com.example.guesstheword.Entities.Word
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao{

    @Query("SELECT * FROM word WHERE (letter=:letter)")
    fun getAllLetterWords(letter: Char): Flow<List<Word>>

    @Query("SELECT * FROM word WHERE (letter=:letter AND difficulty=:difficulty)")
    fun getWordOfLetterFromDifficulty(letter: Char, difficulty: Int): Word?
    @Delete
    suspend fun deleteWord(word: Word)

    @Query("""
        UPDATE word 
        SET letter = :letter,
            correctWord =:correctWord,
            difficulty =:difficulty,
            status = :status,
            tries = :tries,
            image = :image            
    """)
    suspend fun updateWord(
        letter: Char,
        correctWord: String,
        difficulty: Int,
        status: String,
        tries: Int,
        image: String
    )

    @Query("UPDATE word SET tries = :tries WHERE wordId = :wordId")
    suspend fun updateTries(wordId: Long, tries: Int)

    @Query("UPDATE word SET status = :status WHERE wordId = :wordId")
    suspend fun updateStatus(wordId: Long, status: String)

}