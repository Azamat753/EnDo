package com.example.endo.adapters

import android.annotation.SuppressLint
import com.example.core.base.BaseAdapter
import com.example.db.models.WordsModel
import com.example.endo.R
import com.example.endo.databinding.ItemRecentlyAddedWordsBinding

class WordsInDictionaryAdapter : BaseAdapter<WordsModel, ItemRecentlyAddedWordsBinding>(
    R.layout.item_recently_added_words,
    listOf(), ItemRecentlyAddedWordsBinding::inflate
) {
    override fun onBind(binding: ItemRecentlyAddedWordsBinding, model: WordsModel) {
        binding.wordBtn.text = model.wordInEnglish
    }

    @SuppressLint("UseCompatLoadingForDrawables", "ResourceAsColor")
    fun changeWordToRussian(model: WordsModel) {
        with(binding) {
            wordBtn.text = model.wordInRussian
            wordCard.background = binding.wordCard.context.getDrawable(R.drawable.blue_gradient)
            wordBtn.setTextColor(R.color.white)
        }
    }

    @SuppressLint("ResourceAsColor")
    fun changeWordToEnglish(model: WordsModel) {
        with(binding) {
            wordBtn.text = model.wordInEnglish
            wordCard.setCardBackgroundColor(R.color.white)
            wordBtn.setTextColor(R.color.black_color)
        }
    }
}