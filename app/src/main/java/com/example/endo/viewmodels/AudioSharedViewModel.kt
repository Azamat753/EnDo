package com.example.endo.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.db.models.AudioModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AudioSharedViewModel @Inject constructor(
    private var audioModel: AudioModel
) : ViewModel() {
    private val audio = MutableLiveData<Int>()


    fun setAudio(audioChunk: Int) {
        audioModel = AudioModel(audioChunk)
        audio.value = audioChunk
    }

    fun getAudio(): Int {
        return audioModel.audio

    }
}