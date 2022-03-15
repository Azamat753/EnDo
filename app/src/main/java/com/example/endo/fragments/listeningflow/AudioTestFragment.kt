package com.example.endo.fragments.listeningflow

import android.graphics.RenderEffect
import com.example.core.base.BaseFragment
import com.example.endo.databinding.FragmentAudioTestBinding


class AudioTestFragment :
    BaseFragment<FragmentAudioTestBinding>(FragmentAudioTestBinding::inflate) {
    override fun initObserver() {


    }

    override fun initClickers() = with(binding) {
        btnAnswer1.setOnClickListener {
            btnAnswer2.background.alpha = 100
            btnAnswer3.background.alpha = 100
            btnAnswer4.background.alpha = 100
        }
        btnAnswer2.setOnClickListener {


        }
        btnAnswer3.setOnClickListener {

        }
        btnAnswer4.setOnClickListener {

        }


    }


}