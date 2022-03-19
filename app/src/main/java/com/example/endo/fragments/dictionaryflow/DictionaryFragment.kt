package com.example.endo.fragments.dictionaryflow

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.core.base.BaseAdapter
import com.example.core.base.BaseFragment
import com.example.endo.models.CategoryModel
import com.example.endo.R
import com.example.endo.adapters.CategoryAdapter
import com.example.endo.databinding.FragmentDictionaryBinding
import java.util.ArrayList

class DictionaryFragment :
    BaseFragment<FragmentDictionaryBinding>(FragmentDictionaryBinding::inflate),
    BaseAdapter.IBaseAdapterClickListener<CategoryModel> {
    private val adapter = CategoryAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initAdapter() {
        adapter.listener = this
        adapter.setData(getDictionaryCategories())
        binding.dictionaryRecycler.adapter = adapter
    }

    override fun onClick(model: CategoryModel, position: Int) {
        when (model.category) {
            getString(R.string.my_dictionary) -> findNavController().navigate(R.id.myDictionaryFragment)
            getString(R.string.synonyms)-> findNavController().navigate(R.id.myDictionaryFragment)
            getString(R.string.antonyms)-> findNavController().navigate(R.id.myDictionaryFragment)
        }
    }

    private fun getDictionaryCategories(): List<CategoryModel> {
        val list: ArrayList<CategoryModel> = arrayListOf()
        list.add(CategoryModel(getString(R.string.my_dictionary)))
        list.add(CategoryModel(getString(R.string.synonyms)))
        list.add(CategoryModel(getString(R.string.antonyms)))
        return list
    }

    override fun initClickers() {

    }

    override fun initObserver() {

    }
}