package com.example.db.di

import android.content.Context
import android.media.MediaPlayer
import android.widget.Chronometer
import com.example.db.repositories.PlayerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Singleton
    @Provides
    fun provideMediaPlayer(): MediaPlayer {
        return MediaPlayer()
    }

    @Singleton
    @Provides
    fun provideChronometer(context: Context): Chronometer =
        Chronometer(context)

    @Singleton
    @Provides
    fun providePlayerRepository(
        mediaPlayer: MediaPlayer,
        chronometer: Chronometer
    ): PlayerRepository {
        return PlayerRepository(mediaPlayer, chronometer)
    }


}





