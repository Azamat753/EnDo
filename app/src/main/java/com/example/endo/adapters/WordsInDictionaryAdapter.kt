package com.example.endo.adapters

import com.example.core.base.BaseAdapter
import com.example.core.extensions.gone
import com.example.core.extensions.visible
import com.example.db.models.WordsModel
import com.example.endo.R
import com.example.endo.databinding.ItemRecentlyAddedWordsBinding

class WordsInDictionaryAdapter : BaseAdapter<WordsModel, ItemRecentlyAddedWordsBinding>(
    R.layout.item_recently_added_words,
    listOf(), ItemRecentlyAddedWordsBinding::inflate
) {
    override fun onBind(binding: ItemRecentlyAddedWordsBinding, model: WordsModel) {
        binding.wordEnglish.text = model.wordInEnglish
    }

    fun changeWordToRussian(model: WordsModel) {
        with(binding) {
            wordEnglish.text = model.wordInEnglish
        }
    }

    fun changeWordToEnglish(model: WordsModel) {
        with(binding) {
            wordEnglish.text = model.wordInRussian
        }
    }

}