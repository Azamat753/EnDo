package com.example.endo.viewmodels

import androidx.lifecycle.viewModelScope
import com.example.core.base.BaseNetworkViewModel
import com.example.core.utils.Response
import com.example.network.models.antonyms.AntonymsApiModel
import com.example.network.repository.AntonymsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AntonymsApiViewModel@Inject constructor(
    private val repository: AntonymsRepository
) : BaseNetworkViewModel() {

    private val _antonymsApiModel: MutableStateFlow<Response<AntonymsApiModel>?> =
        MutableStateFlow(null)
    val antonymsApiModel = _antonymsApiModel.asStateFlow()

    fun getAntonyms(antonymsInEnglish: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getAntonyms(antonymsInEnglish)
            _antonymsApiModel.emit(response)
        }
    }
}