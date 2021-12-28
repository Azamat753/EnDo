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
import com.example.endo.adapters.GrammarAdapter
import com.example.endo.databinding.FragmentGrammarBinding
import com.example.endo.models.CategoryModel
import java.util.ArrayList


class GrammarFragment : BaseFragment<FragmentGrammarBinding>(FragmentGrammarBinding::inflate),
    BaseAdapter.IBaseAdapterClickListener<CategoryModel> {
    val adapter = GrammarAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initClickers() {

    }

    override fun initAdapter() {
        binding.grammarRecycler.adapter = adapter
        adapter.listener=this
        adapter.setData(getGrammarCategories())
    }

    private fun getGrammarCategories(): List<CategoryModel> {
        val list: ArrayList<CategoryModel> = arrayListOf()
        list.add(CategoryModel("Времена"))
        list.add(CategoryModel("Глагол to be"))
        list.add(CategoryModel("Глагол to have"))
        return list
    }

    override fun onClick(model: CategoryModel, position: Int) {
        findNavController().navigate(R.id.grammarDetailFragment)
    }

    override fun initObserver() {


    }
}