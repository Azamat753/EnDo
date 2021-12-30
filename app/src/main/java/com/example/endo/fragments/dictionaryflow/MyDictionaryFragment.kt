package com.example.endo.fragments.dictionaryflow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.core.base.BaseAdapter
import com.example.core.base.BaseFragment
import com.example.endo.R
import com.example.endo.adapters.CategoryAdapter
import com.example.endo.adapters.MyDictionaryAdapter
import com.example.endo.adapters.WordsInTodayAdapter
import com.example.endo.databinding.FragmentMyDictionaryBinding
import com.example.endo.models.CategoryModel
import java.util.ArrayList

class MyDictionaryFragment :
    BaseFragment<FragmentMyDictionaryBinding>(FragmentMyDictionaryBinding::inflate),
    BaseAdapter.IBaseAdapterClickListener<CategoryModel> {
    private val adapter = MyDictionaryAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    override fun initAdapter() {
        adapter.listener = this
        adapter.setData(getDictionaryCategories())
        binding.myDictionaryRecycler.adapter = adapter
    }

    override fun onClick(model: CategoryModel, position: Int) {
        when (model.category) {
            getString(R.string.my_dictionary) -> findNavController().navigate(R.id.dictionaryCategoryFragment)
            getString(R.string.synonyms) -> findNavController().navigate(R.id.synonymsCategoryFragment)
            getString(R.string.antonyms) -> findNavController().navigate(R.id.antonymsCategoryFragment)
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