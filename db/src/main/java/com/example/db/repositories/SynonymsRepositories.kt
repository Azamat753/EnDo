package com.example.db.repositories

import com.example.db.dao.SynonymsDao
import com.example.db.models.SynonymsModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SynonymsRepositories @Inject constructor(
    private val dao: SynonymsDao
) {
    fun getData(category:String): Flow<List<SynonymsModel>> = dao.getData(category)
    suspend fun insert(model: SynonymsModel) = dao.insertData(model)
    suspend fun update(model: SynonymsModel) = dao.update(model)
}