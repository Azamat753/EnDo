package com.example.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.db.models.WordsModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@Dao
interface WordsDao {
    @Insert
    suspend fun insertData(model: WordsModel)

    @Query("SELECT * FROM words_table WHERE category=:category ")
    fun getData(category:String): Flow<List<WordsModel>>

    @Update
    suspend fun update(model: WordsModel)
}