package com.example.endo.fragments.dictionaryflow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.core.CommonFunction.showBottomSheet
import com.example.core.base.BaseAdapter
import com.example.core.base.BaseFragment
import com.example.core.base.showToast
import com.example.db.models.WordsModel
import com.example.endo.R
import com.example.endo.adapters.WordsInDictionaryAdapter
import com.example.endo.adapters.WordsInTodayAdapter
import com.example.endo.bottomsheetdialogs.AddWordsSheetDialogFragment
import com.example.endo.databinding.FragmentDictionaryCategoryBinding
import com.example.endo.models.CategoryModel
import com.example.endo.viewmodels.WordsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.ArrayList

@AndroidEntryPoint
class DictionaryCategoryFragment :
    BaseFragment<FragmentDictionaryCategoryBinding>(FragmentDictionaryCategoryBinding::inflate),
    BaseAdapter.IBaseAdapterClickListener<WordsModel> {
    private val adapter = WordsInDictionaryAdapter()
    private val viewModel: WordsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initClickers()
    }

    override fun initAdapter() {
        adapter.listener = this
        binding.dictionaryCategoryRecycler.adapter = adapter
        viewModel.viewModelScope.launch {
            viewModel.wordsModel.collect {
                if (it != null) {
                    adapter.setData(it)
                }
            }
        }
    }

    override fun onClick(model: WordsModel, position: Int) {
        val isClicked = false
        if (isClicked) {
            adapter.changeWordToEnglish(model)
            requireContext().showToast(position.toString() + "true")
        } else {
            requireContext().showToast(position.toString() + "false")
            adapter.changeWordToRussian(model)
        }
    }

    override fun initClickers() {
        binding.addWordFab.setOnClickListener {
            showBottomSheet(AddWordsSheetDialogFragment(), requireActivity())
        }
    }
}