package com.example.endo.adapters

import com.example.core.base.BaseAdapter
import com.example.db.models.DictionaryCategoryModel
import com.example.db.models.SynonymsCategoryModel
import com.example.endo.R
import com.example.endo.databinding.ItemDictionaryCategoryBinding

class SynonymsCategoryAdapter : BaseAdapter<SynonymsCategoryModel, ItemDictionaryCategoryBinding>(
    R.layout.item_buttons,
    listOf(), ItemDictionaryCategoryBinding::inflate
) {
    override fun onBind(binding: ItemDictionaryCategoryBinding, model: SynonymsCategoryModel) {
            binding.categoryBtn.text = model.categoryName

    }

}