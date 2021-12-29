package com.example.endo.adapters

import android.annotation.SuppressLint
import androidx.core.view.isVisible
import coil.load
import com.example.core.base.BaseAdapter
import com.example.core.base.gone
import com.example.core.base.visible
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