package com.example.endo.viewmodels

import androidx.lifecycle.viewModelScope
import com.example.core.base.BaseNetworkViewModel
import com.example.core.utils.Response
import com.example.network.models.synonyms.SynonymsApiModel
import com.example.network.repository.SynonymsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SynonymsApiViewModel @Inject constructor(
    private val repository: SynonymsRepository
) : BaseNetworkViewModel() {
    private val _synonymsApiModel: MutableStateFlow<Response<SynonymsApiModel>?> =
        MutableStateFlow(null)
    val synonymsApiModel = _synonymsApiModel.asStateFlow()

    fun getSynonyms(synonymsInEnglish: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getSynonyms(synonymsInEnglish)
            _synonymsApiModel.emit(response)
        }
    }
}