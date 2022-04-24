package com.example.endo.adapters

import com.example.core.base.BaseAdapter
import com.example.db.models.AntonymsModel
import com.example.endo.R
import com.example.endo.databinding.ItemRecentlyAddedAntonymsBinding

class AntonymsDialogAdapter: BaseAdapter<AntonymsModel, ItemRecentlyAddedAntonymsBinding>(
    R.layout.item_recently_added_antonyms,
    listOf(), ItemRecentlyAddedAntonymsBinding::inflate
) {
    override fun onBind(binding: ItemRecentlyAddedAntonymsBinding, model: AntonymsModel) {
        binding.antonymsRecentlyTv.text = model.antonymsInEnglish
    }
}