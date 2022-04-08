package com.example.endo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.db.models.WordsModel
import com.example.db.repositories.WordsRepositories
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordsViewModel @Inject constructor(
    private val repositories: WordsRepositories
) : ViewModel() {

    private val _wordsModel: MutableStateFlow<List<WordsModel>?> = MutableStateFlow(null)
    val wordsModel = _wordsModel.asStateFlow()

    fun insertData(model: WordsModel) =
        viewModelScope.launch(Dispatchers.IO) {
            repositories.insert(model)
        }

    fun updateData(model: WordsModel) =
        viewModelScope.launch(Dispatchers.IO) { repositories.update(model) }

    init {
        getData("Animals")
    }

    fun getData(category: String) {
        viewModelScope.launch {
            repositories.getData(category).collect {
                _wordsModel.emit(it)
            }
        }
    }
}