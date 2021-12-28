package com.example.endo.bottomsheetdialogs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.core.base.BaseBottomSheetDialog
import com.example.db.models.DictionaryCategoryModel
import com.example.endo.R
import com.example.endo.databinding.FragmentAddWordsSheetDiaolgBinding
import com.example.endo.viewmodels.DictionaryCategoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddDictionaryCategorySheetDialogFragment :
    BaseBottomSheetDialog<FragmentAddWordsSheetDiaolgBinding>(FragmentAddWordsSheetDiaolgBinding::inflate) {
    private val viewModel: DictionaryCategoryViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun initClickers() {
        binding.applyButton.setOnClickListener {
            val categoryName = binding.titleEditText.text.toString()
            viewModel.insertData(DictionaryCategoryModel(categoryName = categoryName))
        }
    }
}
