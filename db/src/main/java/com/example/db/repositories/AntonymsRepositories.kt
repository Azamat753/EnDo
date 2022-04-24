package com.example.db.repositories

import com.example.db.dao.AntonymsDao
import com.example.db.models.AntonymsModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AntonymsRepositories  @Inject constructor(
    private val dao: AntonymsDao
) {
    fun getData(category:String): Flow<List<AntonymsModel>> = dao.getData(category)
    suspend fun insert(model: AntonymsModel) = dao.insertData(model)
    suspend fun update(model: AntonymsModel) = dao.update(model)
}