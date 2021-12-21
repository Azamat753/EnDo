package com.example.endo.adapters

import com.example.core.base.BaseAdapter
import com.example.endo.models.CategoryModel
import com.example.endo.R
import com.example.endo.databinding.ItemButtonsBinding

class CategoryAdapter : BaseAdapter<CategoryModel, ItemButtonsBinding>(
    R.layout.item_buttons,
    listOf(), ItemButtonsBinding::inflate
) {
    override fun onBind(binding: ItemButtonsBinding, model: CategoryModel) {
        binding.categoryBtn.text = model.category
    }
}