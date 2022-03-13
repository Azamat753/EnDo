package com.example.endo.fragments.listeningflow

import android.content.res.ColorStateList
import android.graphics.Color
import android.media.MediaPlayer
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.core.base.BaseFragment
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
            viewModel.play(requireContext(), R.raw.john_wick)
            if (MediaPlayer().audioSessionId != -1)
                visualizerBar.setAudioSessionId(MediaPlayer().audioSessionId)

        }
        btnStop.setOnClickListener {

            viewModel.pause()


        }
        btnContinue.setOnClickListener {

//            findNavController().navigate(R.id.)
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        binding.visualizerBar.release()
        viewModel.releasePlayer()
    }

}