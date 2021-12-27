package com.example.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.db.models.AchievementsModel
import com.example.db.models.WordsModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@Dao
interface AchievementsDao {
    @Insert
    suspend fun insertData(model: AchievementsModel)

    @Query("SELECT * FROM achievement_table")
    fun getData(): Flow<List<AchievementsModel>>

    @Update
    suspend fun update(model: AchievementsModel)
}