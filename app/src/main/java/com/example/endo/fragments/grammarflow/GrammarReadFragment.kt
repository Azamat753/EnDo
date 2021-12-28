package com.example.endo.fragments.grammarflow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.core.base.BaseFragment
import com.example.endo.R
import com.example.endo.databinding.FragmentGrammarReadBinding


class GrammarReadFragment :
    BaseFragment<FragmentGrammarReadBinding>(FragmentGrammarReadBinding::inflate) {
    override fun initClickers() {
        binding.understoodBtn.setOnClickListener { findNavController().navigate(R.id.checkGrammarFragment)}
    }

    override fun initObserver() {


    }
}