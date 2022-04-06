package com.example.endo.fragments.listeningflow

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.core.base.BaseFragment
import com.example.endo.databinding.FragmentAudioTestBinding
import com.example.endo.local.Client
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AudioTestFragment :
    BaseFragment<FragmentAudioTestBinding>(FragmentAudioTestBinding::inflate) {

    private var rightAnswers = 0
    private var mistakes = 0
    private var time = 0
    private val args: AudioTestFragmentArgs by navArgs()


    override fun setupViews() {
        getArgs()

    }

    private fun getArgs() {
        getMusicArgs()
        getMovieArgs()
        getBooksArgs()

    }

    private fun getMusicArgs() {
        when (args.positionFromMovieFragment) {


        }
    }

    private fun getMovieArgs() {
        when (args.positionFromMovieFragment) {

            0 -> {
                binding.tvQuestion.text =
                    Client().getMovies()[0].question

                binding.btnAnswer1.text =
                    Client().getMovies()[0].firstAnswer
                binding.btnAnswer2.text =
                    Client().getMovies()[0].secondAnswer
                binding.btnAnswer3.text =
                    Client().getMovies()[0].thirdAnswer
                binding.btnAnswer4.text =
                    Client().getMovies()[0].fourthAnswer
            }
            1 -> {
                binding.tvQuestion.text =
                    Client().getMovies()[1].question
                binding.btnAnswer1.text =
                    Client().getMovies()[1].firstAnswer
                binding.btnAnswer2.text =
                    Client().getMovies()[1].secondAnswer
                binding.btnAnswer3.text =
                    Client().getMovies()[1].thirdAnswer
                binding.btnAnswer4.text =
                    Client().getMovies()[1].fourthAnswer

            }
            2 -> {
                binding.tvQuestion.text =
                    Client().getMovies()[2].question

                binding.btnAnswer1.text =
                    Client().getMovies()[2].firstAnswer
                binding.btnAnswer2.text =
                    Client().getMovies()[2].secondAnswer
                binding.btnAnswer3.text =
                    Client().getMovies()[2].thirdAnswer
                binding.btnAnswer4.text =
                    Client().getMovies()[2].fourthAnswer
            }
            3 -> {
                binding.tvQuestion.text =
                    Client().getMovies()[3].question
                binding.btnAnswer1.text =
                    Client().getMovies()[3].firstAnswer
                binding.btnAnswer2.text =
                    Client().getMovies()[3].secondAnswer
                binding.btnAnswer3.text =
                    Client().getMovies()[3].thirdAnswer
                binding.btnAnswer4.text =
                    Client().getMovies()[3].fourthAnswer
            }

        }

    }

    private fun getBooksArgs() {
    }

    override fun initObserver() {


    }


    override fun initClickers() {
        binding.apply {
            btnAnswer1.setOnClickListener {
                if (Client().getMovies()[args.positionFromMovieFragment].firstAnswer == Client().getMovies()[args.positionFromMovieFragment].correctAnswer) {

                    findNavController().navigate(
                        AudioTestFragmentDirections.actionAudioTestFragmentToCustomListeningDialogFragment(
                            args.positionFromMovieFragment,
                            0,
                            rightAnswers,
                            mistakes,
                            args.amountOfAudioListenedTo,
                            true
                        )
                    )

                } else {
                    mistakes + 1

                    findNavController().navigate(
                        AudioTestFragmentDirections.actionAudioTestFragmentToCustomListeningDialogFragment(
                            args.positionFromMovieFragment,
                            0,
                            rightAnswers,
                            mistakes,
                            args.amountOfAudioListenedTo,
                            false
                        )
                    )
                }
                args.positionFromMovieFragment + 1
                args.amountOfAudioListenedTo + 1


            }
            btnAnswer2.setOnClickListener {
                if (Client().getMovies()[args.positionFromMovieFragment].secondAnswer == Client().getMovies()[args.positionFromMovieFragment].correctAnswer) {
                    rightAnswers + 1


                    findNavController().navigate(
                        AudioTestFragmentDirections.actionAudioTestFragmentToCustomListeningDialogFragment(
                            args.positionFromMovieFragment,
                            0,
                            rightAnswers,
                            mistakes,
                            args.amountOfAudioListenedTo,
                            true
                        )
                    )

                } else {
                    mistakes + 1

                    findNavController().navigate(
                        AudioTestFragmentDirections.actionAudioTestFragmentToCustomListeningDialogFragment(
                            args.positionFromMovieFragment,
                            0,
                            rightAnswers,
                            mistakes,
                            args.amountOfAudioListenedTo,
                            false
                        )
                    )
                }
                args.amountOfAudioListenedTo + 1

                args.positionFromMovieFragment + 1

            }
            btnAnswer3.setOnClickListener {
                if (Client().getMovies()[args.positionFromMovieFragment].thirdAnswer == Client().getMovies()[args.positionFromMovieFragment].correctAnswer) {
                    rightAnswers + 1

                    findNavController().navigate(
                        AudioTestFragmentDirections.actionAudioTestFragmentToCustomListeningDialogFragment(
                            args.positionFromMovieFragment,
                            0,
                            rightAnswers,
                            mistakes,
                            args.amountOfAudioListenedTo,
                            true
                        )
                    )
                } else {
                    mistakes + 1
                    findNavController().navigate(
                        AudioTestFragmentDirections.actionAudioTestFragmentToCustomListeningDialogFragment(
                            args.positionFromMovieFragment,
                            0,
                            rightAnswers,
                            mistakes,
                            args.amountOfAudioListenedTo,
                            false
                        )
                    )
                }
                args.positionFromMovieFragment + 1
                args.amountOfAudioListenedTo + 1

            }
            btnAnswer4.setOnClickListener {
                if (Client().getMovies()[args.positionFromMovieFragment].fourthAnswer == Client().getMovies()[args.positionFromMovieFragment].correctAnswer) {
                    rightAnswers + 1
                    findNavController().navigate(
                        AudioTestFragmentDirections.actionAudioTestFragmentToCustomListeningDialogFragment(
                            args.positionFromMovieFragment,
                            0,
                            rightAnswers,
                            mistakes,
                            args.amountOfAudioListenedTo,
                            false
                        )
                    )
                } else {
                    mistakes + 1
                    findNavController().navigate(
                        AudioTestFragmentDirections.actionAudioTestFragmentToCustomListeningDialogFragment(
                            args.positionFromMovieFragment,
                            0,
                            rightAnswers,
                            mistakes,
                            args.amountOfAudioListenedTo,
                            false
                        )
                    )

                }
                args.positionFromMovieFragment + 1
                args.amountOfAudioListenedTo + 1


            }
        }

    }

}