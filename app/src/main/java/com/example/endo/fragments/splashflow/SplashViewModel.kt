package com.example.endo.fragments.splashflow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
) : ViewModel() {

    companion object {
        private const val SPLASH_DURATION_IN_MILLIS = 1800L
    }

    private val _isSplashFinished = MutableStateFlow(false)
    val isSplashFinished = _isSplashFinished.asStateFlow()

    init {
        viewModelScope.launch {
            delay(SPLASH_DURATION_IN_MILLIS)
            _isSplashFinished.value = true
        }
    }
}