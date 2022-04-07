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
<<<<<<< HEAD

    ) : ViewModel() {
    fun play(@ApplicationContext context: Context, audio: Int): Int {
        return playerRepository.playAMovie(context, audio)
    }
=======
) : ViewModel() {

    fun play(@ApplicationContext context: Context, audio: Int): Int =


        playerRepository.playAMovie(context, audio)

>>>>>>> 79b5c21c3e260d1d8a0eaae4f773b646e6437e3b

    fun pause() {
        playerRepository.pauseAMovie()
    }

    fun releasePlayer() {
        playerRepository.releasePlayer()
    }

//    fun getAudio(): Int {
//        return playerRepository.getAudio()
//    }


}