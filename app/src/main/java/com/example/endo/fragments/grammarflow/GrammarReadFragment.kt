package com.example.endo.fragments.grammarflow

import androidx.navigation.fragment.findNavController
import com.example.core.base.BaseFragment
import com.example.endo.R
import com.example.endo.databinding.FragmentGrammarReadBinding


class GrammarReadFragment :
    BaseFragment<FragmentGrammarReadBinding>(FragmentGrammarReadBinding::inflate) {
    override fun initClickers() {
        binding.understoodBtn.setOnClickListener { findNavController().navigate(R.id.checkGrammarFragment) }
    }

    override fun initObserver() {


    }
}