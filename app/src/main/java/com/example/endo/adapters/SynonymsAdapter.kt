package com.example.endo.adapters

import com.example.core.base.BaseAdapter
import com.example.db.models.SynonymsModel
import com.example.endo.R
import com.example.endo.databinding.ItemSynonymsBinding

class SynonymsAdapter : BaseAdapter<SynonymsModel, ItemSynonymsBinding>(
    R.layout.item_synonyms,
    listOf(), ItemSynonymsBinding::inflate
) {
    override fun onBind(binding: ItemSynonymsBinding, model: SynonymsModel) {
        binding.synonymsTv.text = model.synonymsInEnglish
    }
}
