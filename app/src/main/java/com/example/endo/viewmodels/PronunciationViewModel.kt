package com.example.endo.viewmodels

import androidx.lifecycle.ViewModel
import com.example.network.repository.PronunciationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PronunciationViewModel @Inject constructor(
    private val repository: PronunciationRepository
) : ViewModel() {

    fun getPronunciations() = repository.getPronunciations()
}