package com.example.endo.fragments.dictionaryflow

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.core.base.BaseAdapter
import com.example.core.base.BaseFragment
import com.example.core.utils.CommonFunction.showBottomSheet
import com.example.db.models.DictionaryCategoryModel
import com.example.endo.adapters.DictionaryCategoryAdapter
import com.example.endo.bottomsheetdialogs.AddDictionaryCategorySheetDialogFragment
import com.example.endo.databinding.FragmentDictionaryCategoryBinding
import com.example.endo.viewmodels.DictionaryCategoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DictionaryCategoryFragment :
    BaseFragment<FragmentDictionaryCategoryBinding>(FragmentDictionaryCategoryBinding::inflate),
    BaseAdapter.IBaseAdapterClickListener<DictionaryCategoryModel> {
    private val adapter = DictionaryCategoryAdapter()
    private val viewModel: DictionaryCategoryViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initClickers()
    }

    override fun initAdapter() {
        adapter.listener = this
        binding.dictionaryCategoryRecycler.adapter = adapter
    }

    override fun initClickers() {
        binding.addWordFab.setOnClickListener {
            showBottomSheet(AddDictionaryCategorySheetDialogFragment(), requireActivity(), "")
        }
    }

    override fun onClick(model: DictionaryCategoryModel, position: Int) {
        val action =
            DictionaryCategoryFragmentDirections.actionDictionaryCategoryFragmentToWordsFragment(
                model
            )
        findNavController().navigate(action)
    }

    override fun initObserver() {
        viewModel.viewModelScope.launch {
            viewModel.dictionaryCategoryModel.collect {
                if (it != null) {
                    adapter.setData(it)
                }
            }
        }
    }
}