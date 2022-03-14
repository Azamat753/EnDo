package com.example.endo.fragments.listeningflow

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.core.base.BaseFragment
import com.example.core.extensions.requireAudioPermission
import com.example.endo.R
import com.example.endo.databinding.FragmentMovieBinding
import com.example.endo.viewmodels.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MovieFragment : BaseFragment<FragmentMovieBinding>(FragmentMovieBinding::inflate) {
    private val viewModel: MovieViewModel by viewModels()

    override fun initObserver() {

    }

    override fun initClickers() = with(binding) {
        btnPlay.setOnClickListener {
            btnContinue.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#12aaf0"))

            requireActivity().requireAudioPermission(requireContext(), requireActivity())

            visualizerBar.isEnabled
            visualizerBar.setColor(Color.parseColor("#1DAAF0"))
            visualizerBar.setDensity(65F)
            visualizerBar.setPlayer(viewModel.play(requireContext(), R.raw.john_wick))

        }

        btnStop.setOnClickListener {

            viewModel.pause()
            visualizerBar.release()


        }
        btnContinue.setOnClickListener {
            findNavController().navigate(R.id.)

        }


    }

    override fun onDestroy() = with(binding) {
        super.onDestroy()
        visualizerBar.release()
        viewModel.releasePlayer()
    }

}