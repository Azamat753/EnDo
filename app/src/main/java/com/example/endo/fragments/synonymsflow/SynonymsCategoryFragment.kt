package com.example.endo.fragments.synonymsflow

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.core.base.BaseAdapter
import com.example.core.base.BaseFragment
import com.example.core.utils.CommonFunction.showBottomSheet
import com.example.db.models.SynonymsCategoryModel
import com.example.endo.adapters.SynonymsCategoryAdapter
import com.example.endo.bottomsheetdialogs.AddSynonymsCategorySheetDialogFragment
import com.example.endo.databinding.FragmentSynonymsCategoryBinding
import com.example.endo.viewmodels.SynonymsCategoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SynonymsCategoryFragment : BaseFragment<FragmentSynonymsCategoryBinding>
    (FragmentSynonymsCategoryBinding :: inflate),
      BaseAdapter.IBaseAdapterClickListener<SynonymsCategoryModel> {
    private val adapter = SynonymsCategoryAdapter()
    private val viewModel: SynonymsCategoryViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initClickers()
    }

    override fun initAdapter() {
        adapter.listener = this
        binding.synonymsCategoryRecycler.adapter = adapter
    }

    override fun initClickers() {
        binding.addWordCategorySynonyms.setOnClickListener {
            showBottomSheet(AddSynonymsCategorySheetDialogFragment(), requireActivity(), "")
        }
    }

    override fun onClick(model: SynonymsCategoryModel, position: Int) {
        val action =
            SynonymsCategoryFragmentDirections.actionSynonymsCategoryFragmentToSynonymsFragment(
                model
            )
        findNavController().navigate(action)

    }
    override fun initObserver() {
        viewModel.viewModelScope.launch {
            viewModel.synonymsCategoryModel.collect {
                if (it != null) {
                    adapter.setData(it)
                }
            }
        }
    }
}