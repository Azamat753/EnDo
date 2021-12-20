package com.example.db.repositories

import com.example.db.dao.WordsDao
import com.example.db.models.WordsModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WordsRepositories @Inject constructor
    (
    private val dao: WordsDao
) {

    fun getData(): Flow<List<WordsModel>> {
        return dao.getData()
    }

    suspend fun insert(model: WordsModel) {
        dao.insertData(model)
    }

}