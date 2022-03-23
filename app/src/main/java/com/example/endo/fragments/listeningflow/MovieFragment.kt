package com.example.endo.fragments.listeningflow

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.core.base.BaseFragment
import com.example.core.extensions.requireAudioPermission
import com.example.endo.R
import com.example.endo.databinding.FragmentMovieBinding
import com.example.endo.local.Client
import com.example.endo.viewmodels.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random


@AndroidEntryPoint
class MovieFragment : BaseFragment<FragmentMovieBinding>(FragmentMovieBinding::inflate) {
    private val viewModel: MovieViewModel by activityViewModels()

    private var currentPos = Random.nextInt(Client().getMoviesAudio().size)
    override fun initObserver() {

    }

    override fun initClickers() = with(binding) {
        btnContinue.isEnabled = false
        btnPlay.setOnClickListener {
            if (btnPlay.isPressed) {

                btnContinue.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#12aaf0"))
                btnContinue.isEnabled = true
            }
            requireActivity().requireAudioPermission(requireContext(), requireActivity())
            visualizerBar.setColor(Color.parseColor("#1DAAF0"))
            visualizerBar.setPlayer(
                viewModel.play(
                    requireContext(),
                    Client().getMoviesAudio()[currentPos].audio
                )
            )

        }

        btnStop.setOnClickListener {
            viewModel.pause()
            visualizerBar.release()


        }
        btnContinue.setOnClickListener {
            viewModel.putCount(currentPos)
            findNavController().navigate(R.id.audioTestFragment)

            viewModel.pause()
            visualizerBar.release()

        }

    }

    override fun setArgsValue() {

    }


    override fun onDestroyView() {
        super.onDestroyView()
//        binding.visualizerBar.release()
        viewModel.releasePlayer()
    }

}