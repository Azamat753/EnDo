package com.example.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.db.dao.WordsDao
import com.example.db.models.WordsModel

@Database(entities = [WordsModel::class ], version = 1, exportSchema = false)
abstract class AppDataBase:RoomDatabase() {

    abstract fun dao():WordsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "endo_database"
                )

                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}