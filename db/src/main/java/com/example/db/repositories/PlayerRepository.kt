package com.example.db.repositories

import android.content.Context
import android.media.MediaPlayer
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PlayerRepository @Inject constructor(
    private var mediaPlayer: MediaPlayer?,
<<<<<<< HEAD
//    private var audioModel: AudioModel
=======
>>>>>>> 79b5c21c3e260d1d8a0eaae4f773b646e6437e3b
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

//    fun getAudio(): Int {
//        return audioModel.audio
//
//    }


}



