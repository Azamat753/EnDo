package com.example.endo.fragments.listeningflow

import com.example.core.base.BaseFragment
import com.example.endo.databinding.FragmentAudioTestBinding


class AudioTestFragment :
    BaseFragment<FragmentAudioTestBinding>(FragmentAudioTestBinding::inflate) {
    override fun initObserver() {


    }

    override fun initClickers() = with(binding) {
        btnAnswer1.setOnClickListener {


        }
        btnAnswer2.setOnClickListener {

        }
        btnAnswer3.setOnClickListener {

        }
        btnAnswer4.setOnClickListener {

        }


    }


}