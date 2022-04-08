package com.example.endo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.db.models.DictionaryCategoryModel
import com.example.db.repositories.DictionaryCategoryRepositories
import com.example.db.repositories.SynonymsCategoryRepositories
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SynonymsCategoryViewModel (
    private val repositories: SynonymsCategoryRepositories
) : ViewModel() {

    private val _dictionaryCategoryModel: MutableStateFlow<List<DictionaryCategoryModel>?> = MutableStateFlow(null)
    val dictionaryCategoryModel = _dictionaryCategoryModel.asStateFlow()

    fun insertData(model: DictionaryCategoryModel) =
        viewModelScope.launch(Dispatchers.IO) {
            repositories.insert(model)
        }

    fun updateData(model: DictionaryCategoryModel) =
        viewModelScope.launch(Dispatchers.IO) { repositories.update(model) }

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            repositories.getData().collect {
                _dictionaryCategoryModel.emit(it)
            }
        }
    }
}
