package com.example.db.repositories

import com.example.db.dao.SynonymsCategoryDao
import com.example.db.models.SynonymsCategoryModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SynonymsCategoryRepositories @Inject constructor(
    private val dao: SynonymsCategoryDao
) {
    fun getData(): Flow<List<SynonymsCategoryModel>> = dao.getData()
    suspend fun insert(model: SynonymsCategoryModel) = dao.insertData(model)
    suspend fun update(model: SynonymsCategoryModel) = dao.update(model)
}
