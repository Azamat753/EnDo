package com.example.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.db.models.DictionaryCategoryModel
import com.example.db.models.WordsModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@Dao
interface DictionaryCategoryDao {
    @Insert
    suspend fun insertData(model: DictionaryCategoryModel)

    @Query("SELECT * FROM dictionary_category_table")
    fun getData(): Flow<List<DictionaryCategoryModel>>

    @Update
    suspend fun update(model: DictionaryCategoryModel)
}