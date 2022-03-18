package com.example.endo.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.endo.models.QuestionModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AudioSharedViewModel @Inject constructor(
    private var questionModel: QuestionModel

) : ViewModel() {
    private val audio = MutableLiveData<Int>()


    fun setAudio(audioChunk: Int) {
        questionModel = QuestionModel(audioChunk)
        audio.value = audioChunk
    }

    fun getAudio(): Int {
        return questionModel.audio

    }
}