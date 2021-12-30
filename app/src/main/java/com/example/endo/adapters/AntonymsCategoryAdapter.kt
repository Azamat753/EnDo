package com.example.endo.adapters

import com.example.core.base.BaseAdapter
import com.example.db.models.AntonymsCategoryModel
import com.example.db.models.SynonymsCategoryModel
import com.example.endo.R
import com.example.endo.databinding.ItemDictionaryCategoryBinding

class AntonymsCategoryAdapter : BaseAdapter<AntonymsCategoryModel, ItemDictionaryCategoryBinding>(
    R.layout.item_buttons,
    listOf(), ItemDictionaryCategoryBinding::inflate
) {

    override fun onBind(binding: ItemDictionaryCategoryBinding, model: AntonymsCategoryModel) {
        binding.categoryBtn.text = model.categoryName
    }

}