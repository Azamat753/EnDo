package com.example.endo.fragments.antonymsflow

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.core.base.BaseAdapter
import com.example.core.base.BaseFragment
import com.example.core.utils.CommonFunction
import com.example.db.models.AntonymsCategoryModel
import com.example.endo.adapters.AntonymsCategoryAdapter
import com.example.endo.bottomsheetdialogs.AddAntonymsCategorySheetDialogFragment
import com.example.endo.databinding.FragmentAntonymsCategoryBinding
import com.example.endo.viewmodels.AntonymsCategoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AntonymsCategoryFragment : BaseFragment<FragmentAntonymsCategoryBinding>
    (FragmentAntonymsCategoryBinding :: inflate),
    BaseAdapter.IBaseAdapterClickListener<AntonymsCategoryModel> {
    private val adapter = AntonymsCategoryAdapter()
    private val viewModel: AntonymsCategoryViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initClickers()
    }

    override fun initAdapter() {
        adapter.listener = this
        binding.antonymsCategoryRecycler.adapter = adapter
    }

    override fun initClickers() {
        binding.addWordCategoryAntonyms.setOnClickListener {
            CommonFunction.showBottomSheet(
                AddAntonymsCategorySheetDialogFragment(),
                requireActivity(),
                ""
            )
        }
    }

    override fun initObserver() {
        viewModel.viewModelScope.launch {
            viewModel.antonymsCategoryModel.collect {
                if (it != null) {
                    adapter.setData(it)
                }
            }
        }
    }

    override fun onClick(model: AntonymsCategoryModel, position: Int) {
        val action =
            AntonymsCategoryFragmentDirections.actionAntonymsCategoryFragmentToAntonymsFragment(
                model
            )
        findNavController().navigate(action)
    }
}