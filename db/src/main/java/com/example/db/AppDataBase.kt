package com.example.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.db.dao.AchievementsDao
import com.example.db.dao.WordsDao
import com.example.db.models.WordsModel

@Database(entities = [WordsModel::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun wordsDao(): WordsDao
    abstract fun achievement(): AchievementsDao
}