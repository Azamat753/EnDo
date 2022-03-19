package com.example.endo.fragments.listeningflow

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.core.base.BaseFragment
import com.example.core.extensions.requireAudioPermission
import com.example.endo.R
import com.example.endo.databinding.FragmentMusicBinding
import com.example.endo.viewmodels.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MusicFragment : BaseFragment<FragmentMusicBinding>(FragmentMusicBinding::inflate) {
    private val viewModel: MovieViewModel by viewModels()

    override fun initObserver() {

    }

    override fun initClickers() = with(binding) {
        ibPlay.setOnClickListener {
            btnUnderstood.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#12aaf0"))

            requireActivity().requireAudioPermission(requireContext(), requireActivity())

            visualizerBar.isEnabled
            visualizerBar.setColor(Color.parseColor("#1DAAF0"))
            visualizerBar.setDensity(65F)
            visualizerBar.setPlayer(viewModel.play(requireContext(), R.raw.old_town_road_))
            binding.btnUnderstood.setOnClickListener {
                findNavController().navigate(R.id.checkGrammarFragment)
            }

        }

        ibStop.setOnClickListener {

            viewModel.pause()
            visualizerBar.release()


        }
        btnUnderstood.setOnClickListener {
            findNavController().navigate(R.id.audioMaterialsFragment)

        }


    }

    override fun onDestroy() = with(binding) {
        super.onDestroy()
        visualizerBar.release()
        viewModel.releasePlayer()
    }

}