package com.example.endo.adapters

import com.example.core.base.BaseAdapter
import com.example.db.models.DictionaryCategoryModel
import com.example.endo.models.CategoryModel
import com.example.endo.R
import com.example.endo.databinding.ItemButtonsBinding
import com.example.endo.databinding.ItemDictionaryCategoryBinding

class DictionaryCategoryAdapter : BaseAdapter<DictionaryCategoryModel, ItemDictionaryCategoryBinding>(
    R.layout.item_buttons,
    listOf(), ItemDictionaryCategoryBinding::inflate
) {
    override fun onBind(binding: ItemDictionaryCategoryBinding, model: DictionaryCategoryModel) {
        binding.categoryBtn.text = model.categoryName
    }
}