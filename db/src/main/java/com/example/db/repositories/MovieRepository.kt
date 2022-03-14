package com.example.db.repositories

import android.content.Context
import android.media.MediaPlayer
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private var mediaPlayer: MediaPlayer?
) {
    fun playAMovie(@ApplicationContext context: Context, audio: Int): Int {
        mediaPlayer = MediaPlayer.create(context, audio)
        mediaPlayer?.start()
        return mediaPlayer!!.audioSessionId
    }

    fun pauseAMovie() {
        mediaPlayer?.pause()
    }

    fun releasePlayer() {
        mediaPlayer?.release()
        mediaPlayer = null
    }


}



