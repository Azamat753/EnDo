package com.example.endo.fragments.dictionaryflow

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.navArgs
import com.example.core.CommonFunction
import com.example.core.base.BaseFragment
import com.example.endo.activity.MainActivity
import com.example.endo.adapters.WordsAdapter
import com.example.endo.bottomsheetdialogs.AddDictionaryCategorySheetDialogFragment
import com.example.endo.bottomsheetdialogs.AddWordsBottomSheetDialog
import com.example.endo.databinding.FragmentWordsBinding
import com.example.endo.viewmodels.WordsViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class WordsFragment : BaseFragment<FragmentWordsBinding>(FragmentWordsBinding::inflate) {
    private val args: WordsFragmentArgs by navArgs()
    private val viewModel: WordsViewModel by viewModels()
    private val adapter = WordsAdapter()
    private var categoryName = ""
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeToolbarTitle()
    }

    private fun changeToolbarTitle() {
        categoryName = args.dictionaryCategoryModel.categoryName
        (requireActivity() as MainActivity).binding.toolbarMain.title = categoryName
    }

    override fun initClickers() {
        binding.addWordFab.setOnClickListener {
            CommonFunction.showBottomSheet(
                AddWordsBottomSheetDialog(),
                requireActivity(),
                categoryName
            )
        }
    }

    override fun initAdapter() {
        binding.wordsRecycler.adapter = adapter
    }

    override fun initObserver() {
        viewModel.getData(categoryName)
        viewModel.viewModelScope.launch {
            viewModel.wordsModel.collect {
                if (it != null) {
                    adapter.setData(it)
                }
            }
        }
    }
}