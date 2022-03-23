package com.example.endo.fragments.listeningflow

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.core.base.BaseFragment
import com.example.core.base.showToast
import com.example.endo.databinding.FragmentAudioTestBinding
import com.example.endo.local.Client
import com.example.endo.viewmodels.MovieViewModel
import kotlinx.coroutines.launch


class AudioTestFragment :
    BaseFragment<FragmentAudioTestBinding>(FragmentAudioTestBinding::inflate) {
    private val viewModel: MovieViewModel by activityViewModels()


    override fun setupViews() {
        getArgs()

    }

    private fun getArgs() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.totalCount.observe(viewLifecycleOwner) { count ->
                when (count) {

                    0 -> {
                        binding.tvQuestion.text =
                            Client().getMoviesAudio()[0].question

                        binding.btnAnswer1.text =
                            Client().getMoviesAudio()[0].firstAnswer
                        binding.btnAnswer2.text =
                            Client().getMoviesAudio()[0].secondAnswer
                        binding.btnAnswer3.text =
                            Client().getMoviesAudio()[0].thirdAnswer
                        binding.btnAnswer4.text =
                            Client().getMoviesAudio()[0].fourthAnswer
                    }
                    1 -> {
                        binding.tvQuestion.text =
                            Client().getMoviesAudio()[1].question
                        binding.btnAnswer1.text =
                            Client().getMoviesAudio()[1].firstAnswer
                        binding.btnAnswer2.text =
                            Client().getMoviesAudio()[1].secondAnswer
                        binding.btnAnswer3.text =
                            Client().getMoviesAudio()[1].thirdAnswer
                        binding.btnAnswer4.text =
                            Client().getMoviesAudio()[1].fourthAnswer

                    }
                    2 -> {
                        binding.tvQuestion.text =

                            Client().getMoviesAudio()[2].question


                        binding.btnAnswer1.text =
                            Client().getMoviesAudio()[2].firstAnswer
                        binding.btnAnswer2.text =
                            Client().getMoviesAudio()[2].secondAnswer
                        binding.btnAnswer3.text =
                            Client().getMoviesAudio()[2].thirdAnswer
                        binding.btnAnswer4.text =
                            Client().getMoviesAudio()[2].fourthAnswer
                    }
                    3 -> {
                        binding.tvQuestion.text =
                            Client().getMoviesAudio()[3].question
                        binding.btnAnswer1.text =
                            Client().getMoviesAudio()[3].firstAnswer
                        binding.btnAnswer2.text =
                            Client().getMoviesAudio()[3].secondAnswer
                        binding.btnAnswer3.text =
                            Client().getMoviesAudio()[3].thirdAnswer
                        binding.btnAnswer4.text =
                            Client().getMoviesAudio()[3].fourthAnswer
                    }

                }

            }

        }

    }

    override fun initObserver() {

    }

    override fun initClickers() = with(binding) {
        btnAnswer1.setOnClickListener {

            if (Client().getMoviesAudio()[viewModel.getCount()!!].firstAnswer == Client().getMoviesAudio()[viewModel.getCount()!!].correctAnswer)

                requireContext().showToast("A nice one!")
        }
        btnAnswer2.setOnClickListener {

            if (Client().getMoviesAudio()[viewModel.getCount()!!].secondAnswer == Client().getMoviesAudio()[viewModel.getCount()!!].correctAnswer)
                requireContext().showToast("A nice one!")
        }
        btnAnswer3.setOnClickListener {

            if (Client().getMoviesAudio()[viewModel.getCount()!!].thirdAnswer == Client().getMoviesAudio()[viewModel.getCount()!!].correctAnswer)
                requireContext().showToast("A nice one!")
        }
        btnAnswer4.setOnClickListener {

            if (Client().getMoviesAudio()[viewModel.getCount()!!].fourthAnswer == Client().getMoviesAudio()[viewModel.getCount()!!].correctAnswer)
                requireContext().showToast("A nice one!")
        }


    }


}