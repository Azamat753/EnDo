package com.example.endo.adapters

import com.example.core.base.BaseAdapter
import com.example.endo.models.CategoryModel
import com.example.endo.R
import com.example.endo.databinding.ItemButtonsBinding
import com.example.endo.databinding.ItemGrammarBinding

class GrammarAdapter : BaseAdapter<CategoryModel, ItemGrammarBinding>(
    R.layout.item_grammar,
    listOf(), ItemGrammarBinding::inflate
) {
    override fun onBind(binding: ItemGrammarBinding, model: CategoryModel) {
        binding.grammarThemeBtn.text = model.category
    }
}