package com.example.endo.bottomsheetdialogs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.core.base.BaseBottomSheetDialog
import com.example.db.models.AntonymsCategoryModel
import com.example.endo.databinding.FragmentAddAntonymsCategorySheetDialogBinding
import com.example.endo.viewmodels.AntonymsCategoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddAntonymsCategorySheetDialogFragment :
    BaseBottomSheetDialog<FragmentAddAntonymsCategorySheetDialogBinding>
        (FragmentAddAntonymsCategorySheetDialogBinding :: inflate){

    private val viewModel: AntonymsCategoryViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun initClickers() {
        binding.toCreate.setOnClickListener {
            val categoryName = binding.titleEditText.text.toString()
            viewModel.insertData(AntonymsCategoryModel(categoryName = categoryName))
        }
    }
}