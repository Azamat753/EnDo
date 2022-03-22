package com.example.endo.fragments.listeningflow

import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.core.base.BaseFragment
import com.example.endo.databinding.FragmentAudioTestBinding
import com.example.endo.local.Client


class AudioTestFragment :
    BaseFragment<FragmentAudioTestBinding>(FragmentAudioTestBinding::inflate) {
    private val args: AudioTestFragmentArgs by navArgs()
    override fun setupViews() {
        getArgs()

    }

    private fun getArgs() {
        when (args.positionFromMovieFragment) {
            0 -> {
                binding.tvQuestion.text =
                    Client().getMoviesAudio()[args.positionFromMovieFragment].question

                binding.btnAnswer1.text =
                    Client().getMoviesAudio()[args.positionFromMovieFragment].firstAnswer
                binding.btnAnswer2.text =
                    Client().getMoviesAudio()[args.positionFromMovieFragment].secondAnswer
                binding.btnAnswer3.text =
                    Client().getMoviesAudio()[args.positionFromMovieFragment].thirdAnswer
                binding.btnAnswer4.text =
                    Client().getMoviesAudio()[args.positionFromMovieFragment].fourthAnswer
            }
            1 -> {
                binding.tvQuestion.text =
                    Client().getMoviesAudio()[args.positionFromMovieFragment].question
                binding.btnAnswer1.text =
                    Client().getMoviesAudio()[args.positionFromMovieFragment].firstAnswer
                binding.btnAnswer2.text =
                    Client().getMoviesAudio()[args.positionFromMovieFragment].secondAnswer
                binding.btnAnswer3.text =
                    Client().getMoviesAudio()[args.positionFromMovieFragment].thirdAnswer
                binding.btnAnswer4.text =
                    Client().getMoviesAudio()[args.positionFromMovieFragment].fourthAnswer

            }
            2 -> {
                binding.tvQuestion.text =

                    Client().getMoviesAudio()[args.positionFromMovieFragment].question


                binding.btnAnswer1.text =
                    Client().getMoviesAudio()[args.positionFromMovieFragment].firstAnswer
                binding.btnAnswer2.text =
                    Client().getMoviesAudio()[args.positionFromMovieFragment].secondAnswer
                binding.btnAnswer3.text =
                    Client().getMoviesAudio()[args.positionFromMovieFragment].thirdAnswer
                binding.btnAnswer4.text =
                    Client().getMoviesAudio()[args.positionFromMovieFragment].fourthAnswer
            }
            3 -> {
                binding.tvQuestion.text =
                    Client().getMoviesAudio()[args.positionFromMovieFragment].question
                binding.btnAnswer1.text =
                    Client().getMoviesAudio()[args.positionFromMovieFragment].firstAnswer
                binding.btnAnswer2.text =
                    Client().getMoviesAudio()[args.positionFromMovieFragment].secondAnswer
                binding.btnAnswer3.text =
                    Client().getMoviesAudio()[args.positionFromMovieFragment].thirdAnswer
                binding.btnAnswer4.text =
                    Client().getMoviesAudio()[args.positionFromMovieFragment].fourthAnswer
            }

        }

    }

    override fun initObserver() {

    }

    override fun initClickers() = with(binding) {
        btnAnswer1.setOnClickListener {

            if (btnAnswer1.text == Client().getMoviesAudio()[args.positionFromMovieFragment].correctAnswer)

                Toast.makeText(requireContext(), "Congratulations", Toast.LENGTH_SHORT)
        }
        btnAnswer2.setOnClickListener {

            if (btnAnswer2.text == Client().getMoviesAudio()[args.positionFromMovieFragment].correctAnswer)
                Toast.makeText(requireContext(), "Nice", Toast.LENGTH_SHORT)

        }
        btnAnswer3.setOnClickListener {

            if (btnAnswer3.text == Client().getMoviesAudio()[args.positionFromMovieFragment].correctAnswer)
                Toast.makeText(requireContext(), "Nice", Toast.LENGTH_SHORT)
        }
        btnAnswer4.setOnClickListener {

            if (btnAnswer4.text == Client().getMoviesAudio()[args.positionFromMovieFragment].correctAnswer)
                Toast.makeText(requireContext(), "Nice", Toast.LENGTH_SHORT)
        }


    }


}