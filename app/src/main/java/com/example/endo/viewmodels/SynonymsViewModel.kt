package com.example.endo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.db.models.SynonymsModel
import com.example.db.repositories.SynonymsRepositories
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SynonymsViewModel @Inject constructor(
    private val repositories: SynonymsRepositories
) : ViewModel() {

    private val _synonymsModel: MutableStateFlow<List<SynonymsModel>?> = MutableStateFlow(null)
    val synonymsModel = _synonymsModel.asStateFlow()

    fun insertData(model: SynonymsModel) =
        viewModelScope.launch(Dispatchers.IO) {
            repositories.insert(model)
        }

    init {
        getData("Animals")
    }

    fun getData(category:String) {
        viewModelScope.launch {
            repositories.getData(category).collect {
                _synonymsModel.emit(it)
            }
        }
    }
}