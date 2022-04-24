package com.example.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.db.models.AntonymsModel
import kotlinx.coroutines.flow.Flow

@Dao
interface AntonymsDao {
    @Insert
    suspend fun insertData(model: AntonymsModel)

    @Query("SELECT * FROM antonyms_table WHERE category = :category ")
    fun getData(category: String): Flow<List<AntonymsModel>>

    @Update
    suspend fun update(model: AntonymsModel)
}