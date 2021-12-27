package com.example.endo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.db.models.AchievementsModel
import com.example.db.repositories.AchievementRepositories
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AchievementViewModel @Inject constructor(
    private val repositories: AchievementRepositories
) : ViewModel() {

    private val _achievementModel: MutableStateFlow<List<AchievementsModel>?> = MutableStateFlow(null)
    val achievementsModel = _achievementModel.asStateFlow()

    fun insertData(model: AchievementsModel) =
        viewModelScope.launch(Dispatchers.IO) {
            repositories.insert(model)
        }

    fun updateData(model: AchievementsModel) =
        viewModelScope.launch(Dispatchers.IO) { repositories.update(model) }

    init {
//        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            repositories.getData().collect {
                _achievementModel.emit(it)
            }
        }
    }
}