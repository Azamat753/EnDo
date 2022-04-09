package com.example.endo.fragments.synonyms

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.core.base.BaseAdapter
import com.example.core.base.BaseFragment
import com.example.core.utils.CommonFunction.showBottomSheet
import com.example.db.models.SynonymsCategoryModel
import com.example.endo.adapters.SynonymsCategoryAdapter
import com.example.endo.bottomsheetdialogs.AddSynonymsCategorySheetDialogFragmentFragment
import com.example.endo.databinding.FragmentSynonymsCategoryBinding
import com.example.endo.fragments.dictionaryflow.DictionaryCategoryFragment
import com.example.endo.viewmodels.SynonymsCategoryViewModel
import dagger.hilt.android.AndroidEntryPoint

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


    override fun initObserver() {
    }

    override fun initClickers() {
        binding.addWordCategorySynonyms.setOnClickListener {
            showBottomSheet(AddSynonymsCategorySheetDialogFragmentFragment(), requireActivity(), "")
        }
    }

    override fun onClick(model: SynonymsCategoryModel, position: Int) {

    }
}