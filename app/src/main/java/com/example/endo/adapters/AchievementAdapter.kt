package com.example.endo.adapters

import android.annotation.SuppressLint
import coil.Coil
import coil.load
import com.example.core.base.BaseAdapter
import com.example.db.models.AchievementsModel
import com.example.endo.models.CategoryModel
import com.example.endo.R
import com.example.endo.databinding.ItemAchievementBinding
import com.example.endo.databinding.ItemButtonsBinding
import com.example.endo.databinding.ItemDictionaryCategoryBinding

class AchievementAdapter : BaseAdapter<AchievementsModel, ItemAchievementBinding>(
    R.layout.item_achievement,
    listOf(), ItemAchievementBinding::inflate
) {
    @SuppressLint("SetTextI18n")
    override fun onBind(binding: ItemAchievementBinding, model: AchievementsModel) {
        with(binding){
            achievementImage.load(model.image)
            rankTv.text = model.rank
            conditionTv.text = model.condition
            achievementProgress.progress = model.currentAmountForProgressBar
            achievementProgress.max = model.maxAmountForProgressBar
            progressTv.text = "${model.currentAmountForProgressBar} / ${model.maxAmountForProgressBar}"
        }
    }
}