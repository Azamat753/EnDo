package com.example.endo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.db.models.SynonymsCategoryModel
import com.example.db.repositories.SynonymsCategoryRepositories
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SynonymsCategoryViewModel @Inject constructor (
    private val repositories: SynonymsCategoryRepositories
) : ViewModel() {

    private val _synonymsCategoryModel: MutableStateFlow<List<SynonymsCategoryModel>?> = MutableStateFlow(null)
    val synonymsCategoryModel = _synonymsCategoryModel.asStateFlow()

    fun insertData(model: SynonymsCategoryModel) =
        viewModelScope.launch(Dispatchers.IO) {
            repositories.insert(model)
        }


    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            repositories.getData().collect {
                _synonymsCategoryModel.emit(it)
            }
        }
    }
}
