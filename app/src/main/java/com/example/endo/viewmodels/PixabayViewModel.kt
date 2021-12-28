package com.example.endo.viewmodels

import android.media.Image
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.BaseNetworkViewModel
import com.example.network.PixabayRepository
import com.example.network.models.Hit
import com.example.network.models.ImageResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PixabayViewModel @Inject constructor(
    private val repository: PixabayRepository
) : BaseNetworkViewModel() {
    private val _imageResultModel: MutableStateFlow<String?> = MutableStateFlow(null)
    val imageResultModel = _imageResultModel.asStateFlow()

    fun getImage(image: String) {
        viewModelScope.launch(Dispatchers.IO) {
            handleResponse(repository.getImages(image)) {
                if (it!=null){
                    _imageResultModel.emit(it.hits?.get(0)?.largeImageURL)
                }
            }
        }
    }
}