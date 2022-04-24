package com.example.endo.adapters

import com.example.core.base.BaseAdapter
import com.example.db.models.AntonymsCategoryModel
import com.example.db.models.SynonymsCategoryModel
import com.example.endo.R
import com.example.endo.databinding.ItemAntonymsCategoryBinding
import com.example.endo.databinding.ItemDictionaryCategoryBinding
import com.example.endo.databinding.ItemSynonymsCategoryBinding

class AntonymsCategoryAdapter  : BaseAdapter<AntonymsCategoryModel, ItemAntonymsCategoryBinding>(
    R.layout.item_antonyms_category,
    listOf(), ItemAntonymsCategoryBinding::inflate
) {
    override fun onBind(binding: ItemAntonymsCategoryBinding, model: AntonymsCategoryModel) {
        binding.antonymsCategoryTv.text = model.categoryName
    }
}