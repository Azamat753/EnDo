package com.example.db.repositories

import com.example.db.dao.WordsDao
import com.example.db.models.WordsModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class WordsRepositories @Inject constructor(
    private val dao: WordsDao
) {

    fun getData(category:String): Flow<List<WordsModel>> = dao.getData(category)

    suspend fun insert(model: WordsModel) = dao.insertData(model)
    suspend fun update(model: WordsModel) = dao.update(model)

}