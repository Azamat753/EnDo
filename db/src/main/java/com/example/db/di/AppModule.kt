package com.example.db.di

import android.content.Context
import androidx.room.Room
import com.example.db.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AppDataBase::class.java, "endo_database").build()


    @Provides
    @Singleton
    fun provideWordsDao(appDataBase: AppDataBase) = appDataBase.wordsDao()

//    fun provideAchievementDao(appDataBase: AppDataBase) = a
}