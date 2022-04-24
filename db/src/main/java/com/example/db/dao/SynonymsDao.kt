package com.example.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.db.models.SynonymsModel
import kotlinx.coroutines.flow.Flow

@Dao
interface SynonymsDao {
    @Insert
    suspend fun insertData(model: SynonymsModel)

    @Query("SELECT * FROM synonyms_table WHERE category = :category ")
    fun getData(category:String): Flow<List<SynonymsModel>>

    @Update
    suspend fun update(model: SynonymsModel)
}