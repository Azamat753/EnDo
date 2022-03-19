package com.example.endo.fragments.listeningflow

import com.example.core.base.BaseFragment
import com.example.endo.R
import com.example.endo.databinding.FragmentAudioTestBinding


class AudioTestFragment :
    BaseFragment<FragmentAudioTestBinding>(FragmentAudioTestBinding::inflate) {
    override fun initObserver() {

        when() {
            R.raw.fairytale_ -> {
                binding.btnAnswer1.text = "иди нахуй"
            }
        }

    }

    override fun initClickers() {
    }

}