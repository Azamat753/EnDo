package com.example.endo.fragments.listeningflow

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.core.base.BaseFragment
import com.example.core.extensions.requireAudioPermission
import com.example.endo.databinding.FragmentMovieBinding
import com.example.endo.local.Client
import com.example.endo.viewmodels.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MovieFragment : BaseFragment<FragmentMovieBinding>(FragmentMovieBinding::inflate) {
    private val viewModel: MovieViewModel by viewModels()
    private val args: MovieFragmentArgs by navArgs()
    private var currentPos = 0
    private var audioListenedTo: Int = 0
    override fun initObserver() {

    }

    override fun initClickers() = with(binding) {
        btnPlay.setOnClickListener {
            if (btnPlay.isPressed) {

                btnContinue.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#12aaf0"))
                btnContinue.isEnabled = true
            }


            requireAudioPermission(requireContext(), requireActivity())
            if (args.positionFromDialog != null) {
                visualizerBar.setPlayer(
                    viewModel.play(
                        requireContext(),
                        Client().getMovies()[args.positionFromDialog].audio
                    )

                )

            } else {

                visualizerBar.setPlayer(
                    viewModel.play(
                        requireContext(),
                        Client().getMovies()[0].audio
                    )

                )

            }
            visualizerBar.setColor(Color.parseColor("#1DAAF0"))
            audioListenedTo++
        }

        btnStop.setOnClickListener {
            viewModel.pause()
            visualizerBar.release()


        }
        btnContinue.setOnClickListener {
            findNavController().navigate(
                MovieFragmentDirections.actionMovieFragmentToAudioTestFragment(
                    currentPos, audioListenedTo
                )
            )

            viewModel.pause()
            visualizerBar.release()

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.releasePlayer()
    }

}