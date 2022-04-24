package com.example.endo.adapters

import com.example.core.base.BaseAdapter
import com.example.db.models.SynonymsCategoryModel
import com.example.endo.R
import com.example.endo.databinding.ItemDictionaryCategoryBinding
import com.example.endo.databinding.ItemSynonymsCategoryBinding

class SynonymsCategoryAdapter : BaseAdapter<SynonymsCategoryModel, ItemSynonymsCategoryBinding>(
    R.layout.item_synonyms_category,
    listOf(), ItemSynonymsCategoryBinding::inflate
) {
    override fun onBind(binding: ItemSynonymsCategoryBinding, model: SynonymsCategoryModel) {
        binding.synonymsCategoryTv.text = model.categoryName
    }
}