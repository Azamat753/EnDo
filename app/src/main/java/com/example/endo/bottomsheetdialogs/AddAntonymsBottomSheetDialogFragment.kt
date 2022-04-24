package com.example.endo.bottomsheetdialogs

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.core.base.BaseBottomSheetDialog
import com.example.db.models.AntonymsModel
import com.example.endo.databinding.FragmentAddAntonymsBottomSheetDialogBinding
import com.example.endo.viewmodels.AntonymsApiViewModel
import com.example.endo.viewmodels.AntonymsViewModel
import dagger.hilt.android.AndroidEntryPoint
import android.util.Log
import com.example.core.base.showToast
import com.example.core.base.visible

@AndroidEntryPoint
class AddAntonymsBottomSheetDialogFragment :
    BaseBottomSheetDialog<FragmentAddAntonymsBottomSheetDialogBinding>
        (FragmentAddAntonymsBottomSheetDialogBinding::inflate) {

    private val antonymsViewModel: AntonymsViewModel by viewModels()
    private val antonymsApiViewModel: AntonymsApiViewModel by viewModels()
    private var antonymsInEnglish = ""
    private var antonymsWord= ""
    private var antonyms = ""
    private var isAntonymsReady = false

    private fun initObserve() {
        binding.progressBar.visible()
        observeAntonyms()
        checkOnComplete()
    }


    private fun checkOnComplete() {
        if (isAntonymsReady) {
            insertDataToDB()
            dismiss()
        }
    }

    private fun observeAntonyms() {
        observeResponse(
            antonymsApiViewModel.antonymsApiModel,
            onLoading = { binding.progressBar.isVisible = it },
            onError = {
                Log.e("anime", it.exception.toString())
                requireContext().showToast(it.exception.toString()
                ) },
            onSuccess = {
                if (it != null) {
                    antonymsWord = it.word.toString()
                    isAntonymsReady = true
                    checkOnComplete()
                }
            })
    }


    override fun initClickers() {
        binding.applyButton.setOnClickListener {
            antonymsInEnglish = binding.titleEditText.text.toString()
            antonymsApiViewModel.getAntonyms( antonymsInEnglish )
            initObserve()
        }
    }

    private fun insertDataToDB() {
        antonymsViewModel.insertData(
            AntonymsModel(
                antonymsInEnglish = antonymsInEnglish,
                antonymsWord = antonymsWord,
                antonyms = antonyms,
                category = tag.toString(),
            )
        )
    }
}