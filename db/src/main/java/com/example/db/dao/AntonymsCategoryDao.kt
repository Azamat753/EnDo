package com.example.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.db.models.AntonymsCategoryModel
import kotlinx.coroutines.flow.Flow
@Dao
interface AntonymsCategoryDao {

    @Insert
    suspend fun insertData(model: AntonymsCategoryModel)

    @Query("SELECT * FROM antonyms_category_table")
    fun getData(): Flow<List<AntonymsCategoryModel>>

    @Update
    suspend fun update(model: AntonymsCategoryModel)
}
