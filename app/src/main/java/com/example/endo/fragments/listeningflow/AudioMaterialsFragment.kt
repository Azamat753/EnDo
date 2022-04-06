package com.example.endo.fragments.listeningflow

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.core.base.BaseAdapter
import com.example.core.base.BaseFragment
import com.example.endo.R
import com.example.endo.adapters.CategoryAdapter
import com.example.endo.databinding.FragmentAudioMaterialsBinding
import com.example.endo.models.CategoryModel


class AudioMaterialsFragment :
    BaseFragment<FragmentAudioMaterialsBinding>(FragmentAudioMaterialsBinding::inflate),
    BaseAdapter.IBaseAdapterClickListener<CategoryModel> {
    private val adapter = CategoryAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    override fun initObserver() {
    }

    override fun initClickers() {

    }

    override fun onClick(model: CategoryModel, position: Int) {
        when (model.category) {
            getString(R.string.music) -> findNavController().navigate(R.id.musicFragment)
            getString(R.string.films) -> findNavController().navigate(R.id.movieFragment)
            getString(R.string.books) -> findNavController().navigate(R.id.audioBooksFragment)
        }


    }

    override fun initAdapter() {
        adapter.listener = this
        adapter.setData(getMaterialList())
        binding.audioRecycler.adapter = adapter

    }

    private fun getMaterialList(): List<CategoryModel> {
        val list: ArrayList<CategoryModel> = arrayListOf()
        list.add(CategoryModel(getString(R.string.music)))
        list.add(CategoryModel(getString(R.string.films)))
        list.add(CategoryModel(getString(R.string.books)))
        return list

    }

}