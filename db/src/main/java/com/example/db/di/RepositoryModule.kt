package com.example.db.di

import android.media.MediaPlayer
import com.example.db.models.AudioModel
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
    fun provideMovieRepository(mediaPlayer: MediaPlayer): PlayerRepository {
        return PlayerRepository(mediaPlayer)
    }

    @Singleton
    @Provides
    fun provideAudioModel(audio: Int): AudioModel {
        return AudioModel(audio)
    }

}





