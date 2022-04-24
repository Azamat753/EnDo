package com.example.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.db.models.SynonymsCategoryModel
import kotlinx.coroutines.flow.Flow

@Dao
interface SynonymsCategoryDao {
        @Insert
        suspend fun insertData(model: SynonymsCategoryModel)

        @Query("SELECT * FROM synonyms_category_table")
        fun getData(): Flow<List<SynonymsCategoryModel>>

        @Update
        suspend fun update(model: SynonymsCategoryModel)
}