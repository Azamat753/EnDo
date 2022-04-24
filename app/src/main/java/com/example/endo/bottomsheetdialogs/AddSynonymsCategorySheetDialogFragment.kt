package com.example.endo.bottomsheetdialogs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.core.base.BaseBottomSheetDialog
import com.example.db.models.SynonymsCategoryModel
import com.example.endo.databinding.FragmentAddSynonymsCategorySheetDialogFragmentBinding
import com.example.endo.viewmodels.SynonymsCategoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddSynonymsCategorySheetDialogFragment :
    BaseBottomSheetDialog<FragmentAddSynonymsCategorySheetDialogFragmentBinding>
        (FragmentAddSynonymsCategorySheetDialogFragmentBinding :: inflate){

    private val viewModel: SynonymsCategoryViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun initClickers() {
        binding.applyButton.setOnClickListener {
            val categoryName = binding.titleEditText.text.toString()
            viewModel.insertData(SynonymsCategoryModel(categoryName = categoryName))
        }
    }

}