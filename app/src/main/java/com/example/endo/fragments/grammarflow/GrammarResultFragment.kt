package com.example.endo.fragments.grammarflow

import androidx.navigation.fragment.findNavController
import com.example.core.base.BaseFragment
import com.example.endo.R
import com.example.endo.databinding.FragmentGrammarResultkBinding


class GrammarResultFragment :
    BaseFragment<FragmentGrammarResultkBinding>(FragmentGrammarResultkBinding::inflate) {
    override fun initClickers() {
        binding.onMainBtn.setOnClickListener { findNavController().navigate(R.id.todayFragment) }
    }

    override fun initObserver() {


    }

}