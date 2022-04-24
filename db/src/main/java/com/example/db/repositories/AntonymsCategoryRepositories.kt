package com.example.db.repositories

import com.example.db.dao.AntonymsCategoryDao
import com.example.db.models.AntonymsCategoryModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AntonymsCategoryRepositories @Inject constructor(
    private val dao: AntonymsCategoryDao
) {
    fun getData(): Flow<List<AntonymsCategoryModel>> = dao.getData()
    suspend fun insert(model: AntonymsCategoryModel) = dao.insertData(model)
    suspend fun update(model: AntonymsCategoryModel) = dao.update(model)
}
