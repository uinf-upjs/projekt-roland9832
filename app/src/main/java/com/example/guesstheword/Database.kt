package com.example.guesstheword

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.guesstheword.Dao.WordDao
import com.example.guesstheword.Entities.InitialData
import com.example.guesstheword.Entities.Word
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.io.InputStreamReader

@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun wordDao(): WordDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): AppDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).addCallback(
                    object : RoomDatabase.Callback(){
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            INSTANCE?.let{
                                scope.launch {
                                    initalizeDb(it, context)
                                }
                            }
                        }
                    }
                ).build()
                INSTANCE = instance
                instance
            }
        }

        private suspend fun initalizeDb(database: AppDatabase, context: Context) {
            val gson = Gson()
            val json = context.assets.open(("data.json"))
            val reader = InputStreamReader(json)
            val initialDataType = object : TypeToken<InitialData>() {}.type
            val initalData: InitialData = gson.fromJson(reader, initialDataType)

            initalData.words.forEach{database.wordDao().insertWord(it)}
        }
    }


}

