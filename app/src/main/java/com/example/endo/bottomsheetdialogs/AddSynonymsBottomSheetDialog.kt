package com.example.endo.bottomsheetdialogs

import android.util.Log
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.core.base.BaseBottomSheetDialog
import com.example.core.base.showToast
import com.example.core.base.visible
import com.example.db.models.SynonymsModel
import com.example.endo.databinding.FragmentAddSynonymsBottomSheetDialogBinding
import com.example.endo.viewmodels.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddSynonymsBottomSheetDialog :
    BaseBottomSheetDialog<FragmentAddSynonymsBottomSheetDialogBinding>
        (FragmentAddSynonymsBottomSheetDialogBinding::inflate) {

    private val synonymsViewModel: SynonymsViewModel by viewModels()
    private val synonymsApiViewModel: SynonymsApiViewModel by viewModels()
    private var synonymsInEnglish = ""
    private var synonymsWord= ""
    private var synonyms = ""
    private var isSynonymsReady = false

    private fun initObserve() {
        binding.progressBar.visible()
        observeSynonyms()
        checkOnComplete()
    }


    private fun checkOnComplete() {
        if (isSynonymsReady) {
            insertDataToDB()
            dismiss()
        }
    }

    private fun observeSynonyms() {
        observeResponse(
            synonymsApiViewModel.synonymsApiModel,
            onLoading = { binding.progressBar.isVisible = it },
            onError = {
                Log.e("anime", it.exception.toString())
                requireContext().showToast(it.exception.toString()
            ) },
            onSuccess = {
                if (it != null) {
                    synonymsWord = it.word.toString()
                    isSynonymsReady = true
                    checkOnComplete()
                }
            })
    }


    override fun initClickers() {
        binding.applyButton.setOnClickListener {
            synonymsInEnglish = binding.titleEditText.text.toString()
            synonymsApiViewModel.getSynonyms( synonymsInEnglish )
            initObserve()
        }
    }

    private fun insertDataToDB() {
        synonymsViewModel.insertData(
            SynonymsModel(
                synonymsInEnglish = synonymsInEnglish,
                synonymsWord = synonymsWord,
                synonyms= synonyms,
                category = tag.toString(),
            )
        )
    }
}