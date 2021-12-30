package com.example.endo.viewmodels

import androidx.lifecycle.viewModelScope
import com.example.core.utils.Response
import com.example.core.base.BaseNetworkViewModel
import com.example.network.repository.PixabayRepository
import com.example.network.models.pixabay.ImageResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PixabayViewModel @Inject constructor(
    private val repository: PixabayRepository
) : BaseNetworkViewModel() {
    private val _imageResultModel: MutableStateFlow<Response<ImageResult>?> = MutableStateFlow(null)
    val imageResultModel = _imageResultModel.asStateFlow()

    fun getImage(image: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getImages(image)
            _imageResultModel.emit(response)
        }
    }
}
