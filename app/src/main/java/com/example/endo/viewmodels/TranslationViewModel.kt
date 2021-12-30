package com.example.endo.viewmodels

import androidx.lifecycle.viewModelScope
import com.example.core.utils.Response
import com.example.core.base.BaseNetworkViewModel
import com.example.network.repository.TranslationRepository
import com.example.network.models.translation.TranslationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TranslationViewModel @Inject constructor(
    private val repository: TranslationRepository
) : BaseNetworkViewModel() {
    private val _translateModel: MutableStateFlow<Response<TranslationModel>?> =
        MutableStateFlow(null)
    val translateModel = _translateModel.asStateFlow()

    fun getTranslate(wordInEnglish: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getTranslate(wordInEnglish)
            _translateModel.emit(response)
        }
    }
}
