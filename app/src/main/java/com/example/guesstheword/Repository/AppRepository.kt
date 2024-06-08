package com.example.guesstheword.Repository

import com.example.guesstheword.Dao.WordDao
import com.example.guesstheword.Entities.Word
import kotlinx.coroutines.flow.Flow

class AppRepository(
    private val wordDao: WordDao
) {
    fun getAllLetterWords(letter: Char): Flow<List<Word>> {
        return wordDao.getAllLetterWords(letter)
    }

    fun getWordOfLetterFromDifficulty(letter: Char, difficulty: Int): Word? {
        return wordDao.getWordOfLetterFromDifficulty(letter, difficulty)
    }

    suspend fun updateWord(
        letter: Char,
        correctWord: String,
        difficulty: Int,
        status: String,
        tries: Int,
        image: String
    ) {
        wordDao.updateWord(letter, correctWord, difficulty, status, tries, image)
    }

    suspend fun updateTries(wordId: Long, tries: Int) {
        wordDao.updateTries(wordId, tries)
    }

    suspend fun updateStatus(wordId: Long, status: String) {
        wordDao.updateStatus(wordId, status)
    }
}