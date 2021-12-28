package com.example.endo.fragments.grammarflow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.core.base.BaseAdapter
import com.example.core.base.BaseFragment
import com.example.endo.R
import com.example.endo.adapters.GrammarDetailAdapter
import com.example.endo.databinding.FragmentGrammarDetailBinding
import com.example.endo.models.CategoryModel
import java.util.ArrayList


class GrammarDetailFragment :
    BaseFragment<FragmentGrammarDetailBinding>(FragmentGrammarDetailBinding::inflate),
    BaseAdapter.IBaseAdapterClickListener<CategoryModel> {
    val adapter = GrammarDetailAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun initClickers() {
    }

    override fun initAdapter() {
        binding.grammarDetailRecycler.adapter = adapter
        adapter.listener= this
        adapter.setData(getGrammarDetailCategories())
    }

    private fun getGrammarDetailCategories(): List<CategoryModel> {
        val list: ArrayList<CategoryModel> = arrayListOf()
        list.add(CategoryModel("Present Simple"))
        list.add(CategoryModel("Past Simple"))
        list.add(CategoryModel("Future Simple"))
        return list
    }

    override fun onClick(model: CategoryModel, position: Int) {
        findNavController().navigate(R.id.grammarReadFragment)
    }

    override fun initObserver() {


    }

}