package com.example.endo.result

import android.annotation.SuppressLint
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.core.base.BaseFragment
import com.example.endo.databinding.FragmentResultBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : BaseFragment<FragmentResultBinding>(FragmentResultBinding::inflate) {

    private val args: ResultFragmentArgs by navArgs()
    private var correct = 1
    private var mistake = 0

    override fun initClickers() {
        binding.btnHome.setOnClickListener {
            findNavController().navigate(ResultFragmentDirections.actionResultFragmentToColloquialFragment())

        }
    }

    override fun setArgsValue() {
        setUpResults()
    }

    @SuppressLint("SetTextI18n")
    private fun setUpResults() = with(binding) {
        args.listNotCorrect.forEach {
            if (it) {
                correct++
            } else {
                mistake++
            }
        }
        tvMistake.text = "Ошибся:${mistake}"
        tvTwo.text = "Правильно:${correct}"
        time.text = "Время:${args.time}"
    }
}