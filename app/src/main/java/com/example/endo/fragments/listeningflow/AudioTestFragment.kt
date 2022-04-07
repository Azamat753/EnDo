package com.example.endo.fragments.listeningflow

<<<<<<< HEAD
=======
import androidx.navigation.fragment.findNavController
>>>>>>> 79b5c21c3e260d1d8a0eaae4f773b646e6437e3b
import androidx.navigation.fragment.navArgs
import com.example.core.base.BaseFragment
import com.example.endo.R
import com.example.endo.databinding.FragmentAudioTestBinding
import com.example.endo.local.Client
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AudioTestFragment :
    BaseFragment<FragmentAudioTestBinding>(FragmentAudioTestBinding::inflate) {
<<<<<<< HEAD
    private val args: AudioTestFragmentArgs by navArgs()
=======

    private var rightAnswers = 0
    private var mistakes = 0
    private var time = 0
    private val args: AudioTestFragmentArgs by navArgs()


>>>>>>> 79b5c21c3e260d1d8a0eaae4f773b646e6437e3b
    override fun setupViews() {
        getArgs()

    }

    private fun getArgs() {
<<<<<<< HEAD
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
=======
        getMusicArgs()
        getMovieArgs()
        getBooksArgs()

    }

    private fun getMusicArgs() {
        when(args.positionFromMovieFragment) {

        }
    }

    private fun getMovieArgs() {
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
>>>>>>> 79b5c21c3e260d1d8a0eaae4f773b646e6437e3b
            }

        }

    }

<<<<<<< HEAD
=======
    private fun getBooksArgs() {
    }

>>>>>>> 79b5c21c3e260d1d8a0eaae4f773b646e6437e3b
    override fun initObserver() {


    }

<<<<<<< HEAD
    override fun initClickers() = with(binding) {
        btnAnswer1.setOnClickListener {


        }
        btnAnswer2.setOnClickListener {


        }
        btnAnswer3.setOnClickListener {

        }
        btnAnswer4.setOnClickListener {

        }

=======

    override fun initClickers() {
        binding.apply {
            btnAnswer1.setOnClickListener {
                if (Client().getMoviesAudio()[args.positionFromMovieFragment].firstAnswer == Client().getMoviesAudio()[args.positionFromMovieFragment].correctAnswer) {

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
                if (Client().getMoviesAudio()[args.positionFromMovieFragment].secondAnswer == Client().getMoviesAudio()[args.positionFromMovieFragment].correctAnswer) {
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
                if (Client().getMoviesAudio()[args.positionFromMovieFragment].thirdAnswer == Client().getMoviesAudio()[args.positionFromMovieFragment].correctAnswer) {
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
                if (Client().getMoviesAudio()[args.positionFromMovieFragment].fourthAnswer == Client().getMoviesAudio()[args.positionFromMovieFragment].correctAnswer) {
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
>>>>>>> 79b5c21c3e260d1d8a0eaae4f773b646e6437e3b

    }


}