package com.example.endo.fragments.listeningflow

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.core.base.BaseFragment
import com.example.endo.R
import com.example.endo.dataFragmentAudioResultBinding


class AudioResultFragment :
    BaseFragment<FragmentAudioResultBinding>(FragmentAudioResultBinding::inflate) {

    private val args: AudioResultFragmentArgs by navArgs()
    override fun initObserver() {

    }

    override fun initClickers() {
        btnBackToMain.setOnClickListener {
            findNavController().navigate(R.id.learnFragment)
        }
    }

    override fun setupViews() {

        showResult()
    }

    private fun showResult() {

        apply {
            tvListenedInTotal.text = args.audioListenedTo.toString()
            tvAmountOfRightAnswers.text = args.amountOfRightAnswers.toString()
            tvAmountOfMistakes.text = args.amountOfMistakes.toString()
            tvTotalTime.text = args.time.toString()


        }
    }


}