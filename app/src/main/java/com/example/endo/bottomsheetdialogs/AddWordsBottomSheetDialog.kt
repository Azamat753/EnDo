package com.example.endo.bottomsheetdialogs

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.core.base.BaseBottomSheetDialog
import com.example.core.base.gone
import com.example.core.base.showToast
import com.example.core.base.visible
import com.example.db.models.WordsModel
import com.example.endo.databinding.FragmentAddWordsSheetDiaolgBinding
import com.example.endo.viewmodels.PixabayViewModel
import com.example.endo.viewmodels.TranslationViewModel
import com.example.endo.viewmodels.WordsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddWordsBottomSheetDialog :
    BaseBottomSheetDialog<FragmentAddWordsSheetDiaolgBinding>
        (FragmentAddWordsSheetDiaolgBinding::inflate) {

    private val wordsViewModel: WordsViewModel by viewModels()
    private val pixabayViewModel: PixabayViewModel by viewModels()
    private val translateViewModel: TranslationViewModel by viewModels()
    private var image: String = ""
    private var wordInEnglish = ""
    private var wordInRussian = ""
    private var isImageReady = false
    private var isTranslateReady = false
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun initObserve() {
        binding.progressBar.visible()
        imageObserve()
        translateObserve()
        checkOnComplete()
    }

    private fun checkOnComplete() {
        if (isImageReady && isTranslateReady) {
            insertDataToDB()
            dismiss()
        }
    }

    private fun imageObserve() {
        observeResponse(
            pixabayViewModel.imageResultModel,
            onLoading = {binding.progressBar.isVisible =it },
            onError = { requireContext().showToast(it.exception.toString()) },
            onSuccess = {
                if (it != null) {
                    image = it.hits?.get(0)?.largeImageURL.toString()
                    isImageReady=true
                    checkOnComplete()
                }
            })
    }

    private fun translateObserve() {
        observeResponse(
            translateViewModel.translateModel,
            onLoading = {binding.progressBar.isVisible = it},
            onError = { Log.e("onError", "initObserve: $it") },
            onSuccess = {
                if (it != null) {
                    wordInRussian = it.responseData?.translatedText.toString()
                    isTranslateReady=true
                    checkOnComplete()
                }
            }
        )
    }

    override fun initClickers() {
        binding.applyButton.setOnClickListener {
            wordInEnglish = binding.titleEditText.text.toString()
            pixabayViewModel.getImage(wordInEnglish)
            translateViewModel.getTranslate(wordInEnglish)
            initObserve()
        }
    }

    private fun insertDataToDB() {
        wordsViewModel.insertData(
            WordsModel(
                wordInEnglish = wordInEnglish,
                image = image,
                category = tag.toString(),
                wordInRussian = wordInRussian
            )
        )
    }
}