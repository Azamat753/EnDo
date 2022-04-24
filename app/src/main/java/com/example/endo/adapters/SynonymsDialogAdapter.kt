package com.example.endo.adapters

import com.example.core.base.BaseAdapter
import com.example.db.models.SynonymsModel
import com.example.endo.R
import com.example.endo.databinding.ItemRecentlyAddedSynonymsBinding
import com.example.endo.databinding.ItemRecentlyAddedWordsBinding

class SynonymsDialogAdapter: BaseAdapter<SynonymsModel, ItemRecentlyAddedSynonymsBinding>(
R.layout.item_recently_added_synonyms,
listOf(), ItemRecentlyAddedSynonymsBinding::inflate
) {
    override fun onBind(binding: ItemRecentlyAddedSynonymsBinding, model: SynonymsModel) {
        binding.synonymsRecentlyTv.text = model.synonymsInEnglish
    }
}