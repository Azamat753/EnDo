package com.example.endo.fragments.listeningflow

import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.core.base.BaseFragment
import com.example.endo.R
import com.example.endo.databinding.FragmentAudioTestBinding


class AudioTestFragment :
    BaseFragment<FragmentAudioTestBinding>(FragmentAudioTestBinding::inflate) {
    private val args: AudioTestFragmentArgs by navArgs()
    override fun initObserver() {
//        if (args.audioFromMovieFragment == R.raw.john_wick)
//            Toast.makeText(requireContext(), "Fuck you!", Toast.LENGTH_SHORT)
//        else {
//            Toast.makeText(
//                requireContext(),
//                "Nothing has been sent through safe-args",
//                Toast.LENGTH_SHORT
//            )
//
//        }
        when (args.audioFromMovieFragment) {
            R.raw.john_wick -> {
                Toast.makeText(requireContext(), "Int has been successfully sent ", Toast.LENGTH_SHORT)
                binding.btnAnswer1.text = "fuck you"
            }
            R.raw.dentist -> {
                Toast.makeText(requireContext(), "Fuck You", Toast.LENGTH_SHORT)
                binding.btnAnswer2.text = "slave"
            }
            R.raw.wonder -> {
                Toast.makeText(requireContext(), "Fuck You", Toast.LENGTH_SHORT)
            }
            R.raw.harry_potter -> {
                Toast.makeText(requireContext(), "Fuck You", Toast.LENGTH_SHORT)
            }

        }


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