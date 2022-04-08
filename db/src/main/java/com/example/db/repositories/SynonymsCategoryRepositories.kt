package com.example.db.repositories

import com.example.db.dao.DictionaryCategoryDao
import com.example.db.dao.SynonymsCategoryDao
import com.example.db.models.DictionaryCategoryModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SynonymsCategoryRepositories @Inject constructor(
    private val dao: SynonymsCategoryDao
) {
    fun getData(): Flow<List<DictionaryCategoryModel>> = dao.getData()
    suspend fun insert(model: DictionaryCategoryModel) = dao.insertData(model)
    suspend fun update(model: DictionaryCategoryModel) = dao.update(model)
}
