package com.example.endo.fragments.colloquial

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.core.base.BaseAdapter
import com.example.core.base.BaseFragment
import com.example.endo.R
import com.example.endo.adapters.CategoryAdapter
import com.example.endo.databinding.FragmentColloquialBinding
import com.example.endo.models.CategoryModel

class ColloquialFragment :
    BaseFragment<FragmentColloquialBinding>(FragmentColloquialBinding::inflate),
    BaseAdapter.IBaseAdapterClickListener<CategoryModel> {
    private val adapter = CategoryAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    override fun initAdapter() {
        adapter.listener = this
        adapter.setData(getLearnCategories())
        binding.colloquialRecycler.adapter = adapter
    }


    private fun getLearnCategories(): List<CategoryModel> {
        val list: ArrayList<CategoryModel> = arrayListOf()
        list.add(CategoryModel(getString(R.string.pronunciation)))
        return list
    }

    override fun onClick(model: CategoryModel, position: Int) {
        when (model.category) {
            getString(R.string.pronunciation) -> findNavController().navigate(R.id.pronunciationFragment)

        }

    }

    override fun initObserver() {
    }

    override fun initClickers() {
    }
}