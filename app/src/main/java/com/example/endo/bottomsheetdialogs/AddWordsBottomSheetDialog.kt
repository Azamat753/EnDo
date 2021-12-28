package com.example.endo.bottomsheetdialogs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import com.example.core.base.BaseBottomSheetDialog
import com.example.db.models.WordsModel
import com.example.endo.databinding.FragmentAddWordsSheetDiaolgBinding
import com.example.endo.viewmodels.PixabayViewModel
import com.example.endo.viewmodels.WordsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddWordsBottomSheetDialog :
    BaseBottomSheetDialog<FragmentAddWordsSheetDiaolgBinding>
        (FragmentAddWordsSheetDiaolgBinding::inflate) {
    private val viewModel: WordsViewModel by viewModels()
    private val pixabayViewModel: PixabayViewModel by viewModels()
    private var image: String = ""
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewModelScope.launch {

            pixabayViewModel.imageResultModel.collect {
                if (it != null)
                    image = it
            }
        }
    }

    override fun initClickers() {
        binding.applyButton.setOnClickListener {
            val wordInEnglish = binding.titleEditText.text.toString()
            if (image.isNotEmpty()){
                viewModel.insertData(WordsModel(wordInEnglish = wordInEnglish, image =image, category =tag.toString(), wordInRussian = "russian"))
            }
        }
    }
}