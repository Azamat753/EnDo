package com.example.endo.adapters

import android.view.LayoutInflater
import com.example.core.base.BaseAdapter
import com.example.db.models.WordsModel
import com.example.endo.databinding.ItemRecentlyAddedWordsBinding

class WordsInTodayAdapter(
    holderLayoutId: Int,
    data: List<WordsModel>,
    inflater: (LayoutInflater) -> ItemRecentlyAddedWordsBinding
) : BaseAdapter<WordsModel, ItemRecentlyAddedWordsBinding>(holderLayoutId, data, inflater) {
    override fun onBind(binding: ItemRecentlyAddedWordsBinding, model: WordsModel) {
        binding.wordBtn.text = model.wordInEnglish
    }
}