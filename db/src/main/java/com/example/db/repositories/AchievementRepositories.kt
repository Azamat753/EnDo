package com.example.db.repositories

import com.example.db.dao.AchievementsDao
import com.example.db.dao.WordsDao
import com.example.db.models.AchievementsModel
import com.example.db.models.WordsModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class AchievementRepositories @Inject constructor(
    private val dao: AchievementsDao
) {

    fun getData(): Flow<List<AchievementsModel>> = dao.getData()

    suspend fun insert(model: AchievementsModel) = dao.insertData(model)
    suspend fun update(model: AchievementsModel) = dao.update(model)

}