package com.example.db.repositories

import com.example.db.dao.AchievementsDao
import com.example.db.models.AchievementsModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AchievementRepositories @Inject constructor(
    private val dao: AchievementsDao
) {

    fun getData(): Flow<List<AchievementsModel>> = dao.getData()

    suspend fun insert(model: AchievementsModel) = dao.insertData(model)
    suspend fun update(model: AchievementsModel) = dao.update(model)

}