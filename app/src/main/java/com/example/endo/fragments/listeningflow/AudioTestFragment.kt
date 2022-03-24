package com.example.endo.fragments.listeningflow

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.core.base.BaseFragment
import com.example.endo.R
import com.example.endo.databinding.FragmentAudioTestBinding
import com.example.endo.dialogs.CustomListeningDialogFragment
import com.example.endo.local.Client
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AudioTestFragment :
    BaseFragment<FragmentAudioTestBinding>(FragmentAudioTestBinding::inflate) {
    val dialog = CustomListeningDialogFragment()
    private var currentPos = 0
    private var rightAnswers = 0
    private var mistakes = 0
    private var time = 0
    private val args: AudioTestFragmentArgs by navArgs()


    override fun setupViews() {
        getArgs()

    }

    private fun getArgs() {
        when (args.positionFromMovieFragment) {

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

    override fun initObserver() {

    }


    override fun initClickers() {
        binding.apply {
            btnAnswer1.setOnClickListener {
                if (Client().getMoviesAudio()[args.positionFromMovieFragment].firstAnswer == Client().getMoviesAudio()[args.positionFromMovieFragment].correctAnswer)
                    rightAnswers + 1


                findNavController().navigate(R.id.customListeningDialogFragment)

            }
            btnAnswer2.setOnClickListener {
                if (Client().getMoviesAudio()[args.positionFromMovieFragment].secondAnswer == Client().getMoviesAudio()[args.positionFromMovieFragment].correctAnswer) {
                    rightAnswers + 1
                    findNavController().navigate(AudioTestFragmentDirections.actionAudioTestFragmentToCustomListeningDialogFragment())

                } else {
                    mistakes + 1
                    findNavController().navigate(AudioTestFragmentDirections.actionAudioTestFragmentToCustomListeningDialogFragment())
                }

            }
            btnAnswer3.setOnClickListener {
                if (Client().getMoviesAudio()[args.positionFromMovieFragment].thirdAnswer == Client().getMoviesAudio()[args.positionFromMovieFragment].correctAnswer) {

                    rightAnswers + 1
                    findNavController().navigate(AudioTestFragmentDirections.actionAudioTestFragmentToCustomListeningDialogFragment())
                } else {
                    mistakes + 1
                    findNavController().navigate(AudioTestFragmentDirections.actionAudioTestFragmentToCustomListeningDialogFragment())
                }


            }
            btnAnswer4.setOnClickListener {
                if (Client().getMoviesAudio()[args.positionFromMovieFragment].fourthAnswer == Client().getMoviesAudio()[args.positionFromMovieFragment].correctAnswer) {
                    rightAnswers + 1
                    findNavController().navigate(AudioTestFragmentDirections.actionAudioTestFragmentToCustomListeningDialogFragment())
                } else {
                    mistakes + 1
                    findNavController().navigate(AudioTestFragmentDirections.actionAudioTestFragmentToCustomListeningDialogFragment())
                }


            }
        }

    }


}









