package com.example.endo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.db.models.AntonymsCategoryModel
import com.example.db.repositories.AntonymsCategoryRepositories
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AntonymsCategoryViewModel @Inject constructor (
    private val repositories: AntonymsCategoryRepositories
) : ViewModel() {

    private val _antonymsCategoryModel: MutableStateFlow<List<AntonymsCategoryModel>?> = MutableStateFlow(null)
    val antonymsCategoryModel = _antonymsCategoryModel.asStateFlow()

    fun insertData(model: AntonymsCategoryModel) =
        viewModelScope.launch(Dispatchers.IO) {
            repositories.insert(model)
        }


    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            repositories.getData().collect {
                _antonymsCategoryModel.emit(it)
            }
        }
    }
}
