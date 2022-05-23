package com.example.endo.fragments.synonyms

import android.os.Bundle

import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.core.base.BaseAdapter
import com.example.core.base.BaseFragment
import com.example.core.utils.CommonFunction.showBottomSheet
import com.example.endo.R
import com.example.endo.adapters.CategoryAdapter
import com.example.endo.bottomsheetdialogs.AddDictionaryCategorySheetDialogFragment
import com.example.endo.databinding.FragmentSynonymsBinding
import com.example.endo.models.CategoryModel

class SynonymsFragment :
    BaseFragment<FragmentSynonymsBinding>(FragmentSynonymsBinding::inflate),
    BaseAdapter.IBaseAdapterClickListener<CategoryModel> {
    private val adapter = CategoryAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initAdapter() {
        adapter.listener = this
        adapter.setData(getDictionaryCategories())
        binding.dictionaryCategoryRecycler.adapter = adapter
    }

    override fun onClick(model: CategoryModel, position: Int) {
        when (model.category) {
            getString(R.string.synonyms) -> findNavController().navigate(R.id.synonymsFragment)

        }
    }

    private fun getDictionaryCategories(): List<CategoryModel> {
        val list: ArrayList<CategoryModel> = arrayListOf()
        list.add(CategoryModel(getString(R.string.synonyms)))
        return list
    }

    override fun initClickers() {


    }

    override fun initObserver() {

    }
}


