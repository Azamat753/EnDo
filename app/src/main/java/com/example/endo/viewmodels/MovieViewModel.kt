package com.example.endo.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.db.repositories.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieRepository: MovieRepository

) : ViewModel() {
    fun play(@ApplicationContext context: Context, audio: Int) {
        movieRepository.playAMovie(context, audio)
    }

    fun pause() {
        movieRepository.pauseAMovie()
    }

    fun releasePlayer() {
        movieRepository.releasePlayer()
    }


}