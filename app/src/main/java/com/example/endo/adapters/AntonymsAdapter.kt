package com.example.endo.adapters

import com.example.core.base.BaseAdapter
import com.example.db.models.AntonymsModel
import com.example.endo.R
import com.example.endo.databinding.ItemAntonymsBinding

class AntonymsAdapter : BaseAdapter<AntonymsModel, ItemAntonymsBinding>(
    R.layout.item_antonyms,
    listOf(), ItemAntonymsBinding::inflate
) {
    override fun onBind(binding: ItemAntonymsBinding, model: AntonymsModel) {
        binding.antonymsTv.text = model.antonymsInEnglish
    }
}