package com.example.db.repositories

import android.content.Context
import android.media.MediaPlayer
import android.os.SystemClock
import android.widget.Chronometer
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PlayerRepository @Inject constructor(
    private var mediaPlayer: MediaPlayer?,
    private val chronometer: Chronometer
) {
    fun playAMovie(@ApplicationContext context: Context, audio: Int): Int {
        mediaPlayer = MediaPlayer.create(context, audio)
        mediaPlayer?.start()
        chronometer.start()
        return mediaPlayer!!.audioSessionId
    }

    fun getTimeFromChronometer() =
        SystemClock.elapsedRealtime() - chronometer.base


    fun pauseAMovie() {
        mediaPlayer?.pause()
        chronometer.stop()
    }

    fun releasePlayer() {
        mediaPlayer?.release()
        mediaPlayer = null
    }


}



