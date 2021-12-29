package com.example.endo.adapters

import android.annotation.SuppressLint
import com.example.core.base.BaseAdapter
import com.example.db.models.WordsModel
import com.example.endo.R
import com.example.endo.databinding.ItemRecentlyAddedWordsBinding

class WordsInTodayAdapter : BaseAdapter<WordsModel, ItemRecentlyAddedWordsBinding>(
    R.layout.item_recently_added_words,
    listOf(), ItemRecentlyAddedWordsBinding::inflate
) {
    override fun onBind(binding: ItemRecentlyAddedWordsBinding, model: WordsModel) {
        binding.wordEnglish.text = model.wordInEnglish
    }
}