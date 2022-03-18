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
object DBModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AppDataBase::class.java, "endo_database").build()


    @Provides
    @Singleton
    fun provideWordsDao(appDataBase: AppDataBase) = appDataBase.wordsDao()

    @Provides
    @Singleton
    fun provideAchievementDao(appDataBase: AppDataBase) = appDataBase.achievementDao()

    @Provides
    @Singleton
    fun provideDictionaryCategoryDao(appDataBase: AppDataBase) = appDataBase.dictionaryDao()


}