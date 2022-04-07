package com.example.endo.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.db.repositories.PlayerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val playerRepository: PlayerRepository,
) : ViewModel() {

    fun play(@ApplicationContext context: Context, audio: Int): Int =


        playerRepository.playAMovie(context, audio)


    fun pause() {
        playerRepository.pauseAMovie()
    }

    fun getTime() = playerRepository.getTimeFromChronometer()

    fun releasePlayer() {
        playerRepository.releasePlayer()
    }


}