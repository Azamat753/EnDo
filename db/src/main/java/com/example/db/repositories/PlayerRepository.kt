package com.example.db.repositories

import android.content.Context
import android.media.MediaPlayer
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PlayerRepository @Inject constructor(
    private var mediaPlayer: MediaPlayer?,
//    private var audioModel: AudioModel
) {
    fun playAMovie(@ApplicationContext context: Context, audio: Int): Int {
        mediaPlayer = MediaPlayer.create(context, audio)
        mediaPlayer?.start()
//        audioModel = AudioModel(audio)
        return mediaPlayer!!.audioSessionId
    }

    fun pauseAMovie() {
        mediaPlayer?.pause()
    }

    fun releasePlayer() {
        mediaPlayer?.release()
        mediaPlayer = null
    }

//    fun getMoviesAudio(): Int {
//        return audioModel.audio
//
//    }


}



