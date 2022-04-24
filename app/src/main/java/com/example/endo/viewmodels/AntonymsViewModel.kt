package com.example.endo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.db.models.AntonymsModel
import com.example.db.repositories.AntonymsRepositories
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AntonymsViewModel @Inject constructor(
    private val repositories: AntonymsRepositories
) : ViewModel() {

    private val _antonymsModel: MutableStateFlow<List<AntonymsModel>?> = MutableStateFlow(null)
    val antonymsModel = _antonymsModel.asStateFlow()

    fun insertData(model: AntonymsModel) =
        viewModelScope.launch(Dispatchers.IO) {
            repositories.insert(model)
        }

    init {
        getData("Animals")
    }

    fun getData(category:String) {
        viewModelScope.launch {
            repositories.getData(category).collect {
                _antonymsModel.emit(it)
            }
        }
    }
}