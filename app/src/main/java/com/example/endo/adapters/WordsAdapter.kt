package com.example.endo.adapters

import android.annotation.SuppressLint
import coil.load
import com.example.core.base.BaseAdapter
import com.example.core.base.gone
import com.example.core.base.visible
import com.example.db.models.WordsModel
import com.example.endo.R
import com.example.endo.databinding.ItemWordsBinding

class WordsAdapter : BaseAdapter<WordsModel, ItemWordsBinding>(
    R.layout.item_words,
    listOf(), ItemWordsBinding::inflate
) {
    override fun onBind(binding: ItemWordsBinding, model: WordsModel) {
        binding.wordTv.text = model.wordInEnglish
    }

    fun changeWordToRussian(model: WordsModel) {
        with(binding) {
            changeViewCard(true)
            wordTv.text = model.wordInRussian
            associationImage.load(model.image)
        }
    }

    fun changeWordToEnglish(model: WordsModel) {
        with(binding) {
            changeViewCard(false)
            wordTv.text = model.wordInEnglish
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun changeViewCard(isWithImage: Boolean) {
        if (isWithImage) {
            binding.translateWrapper.setBackgroundResource(R.drawable.blue_gradient)
            binding.wordTv.setTextColor(R.color.white)
            binding.associationImage.visible()
        } else {
            binding.translateWrapper.setBackgroundResource(R.color.white)
            binding.wordTv.setTextColor(R.color.black_color)
            binding.associationImage.gone()
        }
    }
}