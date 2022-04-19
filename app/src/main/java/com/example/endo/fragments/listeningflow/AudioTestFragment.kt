package com.example.endo.fragments.listeningflow

import androidx.navigation.fragment.navArgs
import com.example.core.base.BaseFragment
import com.example.endo.common.Constants.MOVIES
import com.example.endo.common.Constants.MUSIC
import com.example.endo.databinding.FragmentAudioTestBinding
import com.example.local.Client
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AudioTestFragment :
    BaseFragment<FragmentAudioTestBinding>(FragmentAudioTestBinding::inflate) {

    private var rightAnswers = 0
    private var mistakes = 0
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
        if (args.questionsToShow == MUSIC) {
            binding.apply {
                when (args.positionFromAudioFragments) {
                    0 -> {
                        tvQuestion.text = Client().getMusic()[0].question
                        btnAnswer1.text =
                            Client().getMusic()[0].firstAnswer
                        btnAnswer2.text =
                            Client().getMusic()[0].secondAnswer
                        btnAnswer3.text =
                            Client().getMusic()[0].thirdAnswer
                        btnAnswer4.text =
                            Client().getMusic()[0].fourthAnswer
                    }
                    1 -> {
                        tvQuestion.text =
                            Client().getMusic()[1].question
                        btnAnswer1.text =
                            Client().getMusic()[1].firstAnswer
                        btnAnswer2.text =
                            Client().getMusic()[1].secondAnswer
                        btnAnswer3.text =
                            Client().getMusic()[1].thirdAnswer
                        btnAnswer4.text =
                            Client().getMusic()[1].fourthAnswer
                    }
                    2 -> {
                        tvQuestion.text =
                            Client().getMusic()[2].question

                        btnAnswer1.text =
                            Client().getMusic()[2].firstAnswer
                        btnAnswer2.text =
                            Client().getMusic()[2].secondAnswer
                        btnAnswer3.text =
                            Client().getMusic()[2].thirdAnswer
                        btnAnswer4.text =
                            Client().getMusic()[2].fourthAnswer
                    }
                    3 -> {
                        btnAnswer1.text =
                            Client().getMusic()[3].firstAnswer
                        btnAnswer2.text =
                            Client().getMusic()[3].secondAnswer
                        btnAnswer3.text =
                            Client().getMusic()[3].thirdAnswer
                        btnAnswer4.text =
                            Client().getMusic()[3].fourthAnswer
                    }

                }
            }
        }


    }

    private fun getMovieArgs() {

        if (args.questionsToShow == MUSIC) {
            binding.apply {
                when (args.positionFromAudioFragments) {
                    0 -> {
                        tvQuestion.text = Client().getMovies()[0].question
                        btnAnswer1.text =
                            Client().getMovies()[0].firstAnswer
                        btnAnswer2.text =
                            Client().getMovies()[0].secondAnswer
                        btnAnswer3.text =
                            Client().getMovies()[0].thirdAnswer
                        btnAnswer4.text =
                            Client().getMovies()[0].fourthAnswer
                    }
                    1 -> {
                        tvQuestion.text =
                            Client().getMovies()[1].question
                        btnAnswer1.text =
                            Client().getMovies()[1].firstAnswer
                        btnAnswer2.text =
                            Client().getMovies()[1].secondAnswer
                        btnAnswer3.text =
                            Client().getMovies()[1].thirdAnswer
                        btnAnswer4.text =
                            Client().getMovies()[1].fourthAnswer

                    }
                    2 -> {

                        tvQuestion.text =
                            Client().getMovies()[2].question

                        btnAnswer1.text =
                            Client().getMovies()[2].firstAnswer
                        btnAnswer2.text =
                            Client().getMovies()[2].secondAnswer
                        btnAnswer3.text =
                            Client().getMovies()[2].thirdAnswer
                        btnAnswer4.text =
                            Client().getMovies()[2].fourthAnswer

                    }
                    3 -> {
                        btnAnswer1.text =
                            Client().getMovies()[3].firstAnswer
                        btnAnswer2.text =
                            Client().getMovies()[3].secondAnswer
                        btnAnswer3.text =
                            Client().getMovies()[3].thirdAnswer
                        btnAnswer4.text =
                            Client().getMovies()[3].fourthAnswer
                    }
                }

            }


        }

    }


    private fun getBooksArgs() {
        if (args.questionsToShow == MOVIES) {
            binding.apply {

                when (args.positionFromAudioFragments) {

                    0 -> {
                        tvQuestion.text = Client().getBooks()[0].question
                        btnAnswer1.text =
                            Client().getBooks()[0].firstAnswer
                        btnAnswer2.text =
                            Client().getBooks()[0].secondAnswer
                        btnAnswer3.text =
                            Client().getBooks()[0].thirdAnswer
                        btnAnswer4.text =
                            Client().getBooks()[0].fourthAnswer
                    }
                    1 -> {
                        tvQuestion.text =
                            Client().getBooks()[1].question
                        btnAnswer1.text =
                            Client().getBooks()[1].firstAnswer
                        btnAnswer2.text =
                            Client().getBooks()[1].secondAnswer
                        btnAnswer3.text =
                            Client().getBooks()[1].thirdAnswer
                        btnAnswer4.text =
                            Client().getBooks()[1].fourthAnswer

                    }
                    2 -> {
                        tvQuestion.text =
                            Client().getBooks()[2].question

                        btnAnswer1.text =
                            Client().getBooks()[2].firstAnswer
                        btnAnswer2.text =
                            Client().getBooks()[2].secondAnswer
                        btnAnswer3.text =
                            Client().getBooks()[2].thirdAnswer
                        btnAnswer4.text =
                            Client().getBooks()[2].fourthAnswer

                    }
                    3 -> {
                        btnAnswer1.text =
                            Client().getBooks()[3].firstAnswer
                        btnAnswer2.text =
                            Client().getBooks()[3].secondAnswer
                        btnAnswer3.text =
                            Client().getBooks()[3].thirdAnswer
                        btnAnswer4.text =
                            Client().getBooks()[3].fourthAnswer
                    }
                }


            }
        }

    }

    override fun initObserver() {


    }


    override fun initClickers() {
    }
}