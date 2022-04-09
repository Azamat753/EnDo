package com.example.endo.fragments.antonyms

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
import com.example.endo.databinding.FragmentAntonymsBinding
import com.example.endo.databinding.FragmentSynonymsBinding
import com.example.endo.models.CategoryModel

class AntonymsFragment :
    BaseFragment<FragmentAntonymsBinding>(FragmentAntonymsBinding::inflate),
    BaseAdapter.IBaseAdapterClickListener<CategoryModel> {
    private val adapter = CategoryAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initAdapter() {
        adapter.listener = this
        adapter.setData(getDictionaryCategories())
        binding.antonymsCategoryRecycler.adapter = adapter
    }

    override fun onClick(model: CategoryModel, position: Int) {
        when (model.category) {
            getString(R.string.antonyms) -> findNavController().navigate(R.id.antonymsCategoryFragment)
        }
    }

    private fun getDictionaryCategories(): List<CategoryModel> {
        val list: ArrayList<CategoryModel> = arrayListOf()
        list.add(CategoryModel(getString(R.string.antonyms)))
        return list
    }

    override fun initClickers() {


    }

    override fun initObserver() {

    }
}

