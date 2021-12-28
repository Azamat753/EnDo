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
import com.example.endo.databinding.ItemWordsBinding

class WordsAdapter : BaseAdapter<WordsModel, ItemWordsBinding>(
    R.layout.item_words,
    listOf(), ItemWordsBinding::inflate
) {
    override fun onBind(binding: ItemWordsBinding, model: WordsModel) {
        binding.wordBtn.text = model.wordInEnglish
    }

    fun changeWordToRussian(model: WordsModel) {
        with(binding) {
            detectCard(true)
            wordBtn.text = model.wordInRussian
        }
    }

    fun changeWordToEnglish(model: WordsModel) {
        with(binding) {
            detectCard(false)
            wordBtn.text = model.wordInEnglish
            associationImage.load(model.image)
        }
    }

    private fun detectCard(isRussian: Boolean) {
        if (isRussian) {
            binding.wordBtn.isVisible
            binding.translateWrapper.gone()
        } else {
            binding.wordBtn.gone()
            binding.translateWrapper.visible()
        }
    }
}