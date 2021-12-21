package com.example.endo.adapters

import com.example.core.base.BaseAdapter
import com.example.endo.models.CategoryModel
import com.example.endo.R
import com.example.endo.databinding.ItemButtonsBinding
import com.example.endo.databinding.ItemDictionaryCategoryBinding

class MyDictionaryAdapter : BaseAdapter<CategoryModel, ItemDictionaryCategoryBinding>(
    R.layout.item_dictionary_category,
    listOf(), ItemDictionaryCategoryBinding::inflate
) {
    override fun onBind(binding: ItemDictionaryCategoryBinding, model: CategoryModel) {
        binding.categoryBtn.text = model.category
    }
}