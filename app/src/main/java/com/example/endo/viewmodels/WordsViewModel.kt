package com.example.endo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.db.models.WordsModel
import com.example.db.repositories.WordsRepositories
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.concurrent.Flow
import javax.inject.Inject

class WordsViewModel @Inject constructor(private val repositories: WordsRepositories) : ViewModel() {


    private val _wordsModel: MutableStateFlow<WordsModel?> = MutableStateFlow(null)
    val wordsModel = _wordsModel.asStateFlow()

    fun insertData(model: WordsModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repositories.insert(model)
        }
    }

    fun getData(model: WordsModel) {
        viewModelScope.launch(Dispatchers.IO) {
            _wordsModel.emit(model)
        }
    }
}
