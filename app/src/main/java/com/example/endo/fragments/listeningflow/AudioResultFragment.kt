package com.example.endo.fragments.listeningflow

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.core.base.BaseFragment
import com.example.endo.R
import com.example.endo.databinding.FragmentAudioResultBinding


class AudioResultFragment :
    BaseFragment<FragmentAudioResultBinding>(FragmentAudioResultBinding::inflate) {

    private val args: AudioResultFragmentArgs by navArgs()
    override fun initObserver() {

    }

    override fun initClickers() {
        binding.btnBackToMain.setOnClickListener {
            findNavController().navigate(R.id.learnFragment)
        }
    }

    override fun setupViews() {
        showResult()
    }

    private fun showResult() {

        binding.apply {
            tvListenedInTotal.text = "Всего прослушано: ${args.audioListenedTo}"
            tvAmountOfRightAnswers.text = "Правильно:${args.amountOfRightAnswers}"
            tvAmountOfMistakes.text = "Ошибся ${args.amountOfMistakes}"
            tvTotalTime.text = "Время: ${args.time}"
        }
    }


}