package com.example.endo.fragments.listeningflow

import android.graphics.RenderEffect
import android.view.MotionEvent
import android.view.View
import com.example.core.base.BaseFragment
import com.example.endo.databinding.FragmentAudioTestBinding


class AudioTestFragment :
    BaseFragment<FragmentAudioTestBinding>(FragmentAudioTestBinding::inflate) {
    override fun initObserver() {


    }

    override fun initClickers() = with(binding) {
        btnAnswer2.setOnClickListener {


        }
        btnAnswer3.setOnClickListener {

        }
        btnAnswer4.setOnClickListener {

        }
        btnAnswer1.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
                btnAnswer1.isPressed = true
                btnAnswer2.background.alpha = 50
                btnAnswer3.background.alpha = 50
                btnAnswer4.background.alpha = 50

                return true
            }
        })



    }


}