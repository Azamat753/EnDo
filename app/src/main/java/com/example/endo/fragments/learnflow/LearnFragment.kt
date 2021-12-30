package com.example.endo.fragments.learnflow

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.core.base.BaseAdapter
import com.example.core.base.BaseFragment
import com.example.endo.models.CategoryModel
import com.example.endo.R
import com.example.endo.adapters.CategoryAdapter
import com.example.endo.databinding.FragmentLearnBinding
import java.util.ArrayList

class LearnFragment : BaseFragment<FragmentLearnBinding>(FragmentLearnBinding::inflate),
    BaseAdapter.IBaseAdapterClickListener<CategoryModel> {
    private val adapter = CategoryAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    override fun initAdapter() {
        adapter.listener = this
        adapter.setData(getLearnCategories())
        binding.learnRecycler.adapter = adapter
    }

    override fun onClick(model: CategoryModel, position: Int) {
        when (model.category) {
            getString(R.string.dictionary_learn) -> findNavController().navigate(R.id.dictionaryFragment)
            getString(R.string.grammar_learn)->findNavController().navigate(R.id.grammarFragment)
        }
    }

    private fun getLearnCategories(): List<CategoryModel> {
        val list: ArrayList<CategoryModel> = arrayListOf()
        list.add(CategoryModel(getString(R.string.audio_learn)))
        list.add(CategoryModel(getString(R.string.grammar_learn)))
        list.add(CategoryModel(getString(R.string.speaking_learn)))
        list.add(CategoryModel(getString(R.string.dictionary_learn)))
        return list
    }

    override fun initClickers() {


    }

    override fun initObserver() {

    }
}