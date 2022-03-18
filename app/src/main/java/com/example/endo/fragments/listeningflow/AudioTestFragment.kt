package com.example.endo.fragments.listeningflow

import androidx.navigation.fragment.navArgs
import com.example.core.base.BaseFragment
import com.example.endo.R
import com.example.endo.databinding.FragmentAudioTestBinding


class AudioTestFragment :
    BaseFragment<FragmentAudioTestBinding>(FragmentAudioTestBinding::inflate) {
    private val args: AudioTestFragmentArgs by navArgs()
    override fun setupViews() {
        getArgs()

    }

    private fun getArgs() {
        when (args.audioFromMovieFragment) {
            R.raw.john_wick -> {
                binding.tvQuestion.text = getString(R.string.questionForJohnWick)

                binding.btnAnswer1.text = getString(R.string.firstAnswerForJohnWick)
                binding.btnAnswer2.text = getString(R.string.secondAnswerForJohnWick)
                binding.btnAnswer3.text = getString(R.string.thirdAnswerForJohnWick)
                binding.btnAnswer4.text = getString(R.string.fourthAnswerForJohnWick)
            }
            R.raw.dentist -> {
                binding.tvQuestion.text = getString(R.string.questionForDentist)

                binding.btnAnswer1.text = getString(R.string.firstAnswerForDentist)
                binding.btnAnswer2.text = getString(R.string.secondAnswerForDentist)
                binding.btnAnswer3.text = getString(R.string.thirdAnswerForDentist)
                binding.btnAnswer4.text = getString(R.string.fourthAnswerForDentist)

            }
            R.raw.wonder -> {
                binding.tvQuestion.text = getString(
                    R.string.questionForWonder
                )
                binding.btnAnswer1.text = getString(R.string.firstAnswerForWonder)
                binding.btnAnswer2.text = getString(R.string.secondAnswerForWonder)
                binding.btnAnswer3.text = getString(R.string.thirdAnswerForWonder)
                binding.btnAnswer4.text = getString(R.string.fourthAnswerForWonder)
            }
            R.raw.harry_potter -> {
                binding.tvQuestion.text = getString(R.string.questionForHarryPotter)
                binding.btnAnswer1.text = getString(R.string.firstAnswerForHarryPotter)
                binding.btnAnswer2.text = getString(R.string.secondAnswerForHarryPotter)
                binding.btnAnswer3.text = getString(R.string.thirdAnswerForHarryPotter)
                binding.btnAnswer4.text = getString(R.string.fourthAnswerForHarryPotter)
            }

        }

    }

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