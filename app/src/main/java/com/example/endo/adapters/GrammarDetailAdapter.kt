package com.example.endo.adapters

import com.example.core.base.BaseAdapter
import com.example.endo.R
import com.example.endo.databinding.ItemGrammarBinding
import com.example.endo.models.CategoryModel

class GrammarDetailAdapter : BaseAdapter<CategoryModel, ItemGrammarBinding>(
    R.layout.item_grammar,
    listOf(), ItemGrammarBinding::inflate
) {
    override fun onBind(binding: ItemGrammarBinding, model: CategoryModel) {
        binding.grammarThemeBtn.text = model.category
    }
}