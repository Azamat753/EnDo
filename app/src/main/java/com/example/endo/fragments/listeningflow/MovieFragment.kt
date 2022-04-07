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
        btnContinue.isEnabled = false
        btnPlay.setOnClickListener {
<<<<<<< HEAD
            btnContinue.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#12aaf0"))
            requireActivity().requireAudioPermission(requireContext(), requireActivity())
            visualizerBar.setColor(Color.parseColor("#1DAAF0"))
            visualizerBar.setPlayer(viewModel.play(requireContext(), R.raw.wonder))
=======
            if (btnPlay.isPressed) {

                btnContinue.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#12aaf0"))
                btnContinue.isEnabled = true
            }

            args.positionFromDialog?.let {
                visualizerBar.setPlayer(
                    viewModel.play(
                        requireContext(),
                        Client().getMoviesAudio()[args.positionFromDialog].audio
                    )
                )
            }
            requireActivity().requireAudioPermission(requireContext(), requireActivity())
            visualizerBar.setColor(Color.parseColor("#1DAAF0"))
            visualizerBar.setPlayer(
                viewModel.play(
                    requireContext(),
                    Client().getMoviesAudio()[0].audio
                )

            )

            audioListenedTo++
>>>>>>> 79b5c21c3e260d1d8a0eaae4f773b646e6437e3b

        }

        btnStop.setOnClickListener {
            viewModel.pause()
            visualizerBar.release()


        }
        btnContinue.setOnClickListener {
<<<<<<< HEAD
            findNavController().navigate(R.id.audioMaterialsFragment)
            val action = MovieFragmentDirections.actionMovieFragmentToAudioTestFragment(
                R.raw.wonder
            )
//            findNavController().navigate(action)
            viewModel.pause()
            visualizerBar.release()
=======
            findNavController().navigate(
                MovieFragmentDirections.actionMovieFragmentToAudioTestFragment(
                    currentPos, audioListenedTo
                )
            )
>>>>>>> 79b5c21c3e260d1d8a0eaae4f773b646e6437e3b

            viewModel.pause()
            visualizerBar.release()

<<<<<<< HEAD
    }

    override fun setArgsValue() {
=======
        }
>>>>>>> 79b5c21c3e260d1d8a0eaae4f773b646e6437e3b

    }


<<<<<<< HEAD
    override fun onDestroy() = with(binding) {
        super.onDestroy()
        visualizerBar.release()
=======
    override fun onDestroyView() {
        super.onDestroyView()

>>>>>>> 79b5c21c3e260d1d8a0eaae4f773b646e6437e3b
        viewModel.releasePlayer()
    }

}