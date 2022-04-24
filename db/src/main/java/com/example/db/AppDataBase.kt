package com.example.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.db.dao.*
import com.example.db.models.*

@Database (entities = [WordsModel::class,
AchievementsModel::class,
DictionaryCategoryModel::class,
SynonymsCategoryModel::class,
SynonymsModel::class,
AntonymsCategoryModel::class,
AntonymsModel::class], version = 1, exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun wordsDao(): WordsDao
    abstract fun synonymsDao(): SynonymsDao
    abstract fun antonymsDao(): AntonymsDao
    abstract fun achievementDao(): AchievementsDao
    abstract fun dictionaryDao(): DictionaryCategoryDao
    abstract fun synonymsCategoryDao(): SynonymsCategoryDao
    abstract fun antonymsCategoryDao(): AntonymsCategoryDao
}