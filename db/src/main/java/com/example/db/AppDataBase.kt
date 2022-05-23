package com.example.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.db.dao.AchievementsDao
import com.example.db.dao.DictionaryCategoryDao
import com.example.db.dao.WordsDao
import com.example.db.models.AchievementsModel
import com.example.db.models.DictionaryCategoryModel
import com.example.db.models.WordsModel

@Database(
    entities = [WordsModel::class, AchievementsModel::class, DictionaryCategoryModel::class],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun wordsDao(): WordsDao
    abstract fun achievementDao(): AchievementsDao
    abstract fun dictionaryDao(): DictionaryCategoryDao
}