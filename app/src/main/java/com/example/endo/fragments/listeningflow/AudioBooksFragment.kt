package com.example.endo.fragments.listeningflow

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.core.base.BaseFragment
import com.example.core.extensions.requireAudioPermission
import com.example.endo.common.Constants.AUDIO_BOOKS
import com.example.endo.databinding.FragmentAudioBooksBinding
import com.example.endo.viewmodels.AudioBooksViewModel
import com.example.local.Client

class AudioBooksFragment :
    BaseFragment<FragmentAudioBooksBinding>(FragmentAudioBooksBinding::inflate) {
    private val viewModel: AudioBooksViewModel by viewModels()
    private val args: AudioBooksFragmentArgs by navArgs()
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
                        Client().getBooks()[args.positionFromDialog].audio
                    )

                )
                chronometer.start()

            } else {

                visualizerBar.setPlayer(
                    viewModel.play(
                        requireContext(),
                        Client().getBooks()[0].audio
                    )

                )

                chronometer.start()
            }
            visualizerBar.setColor(Color.parseColor("#1DAAF0"))
            audioListenedTo++
        }

        btnStop.setOnClickListener {
            viewModel.pause()
            binding.chronometer.stop()
            visualizerBar.release()


        }
        btnContinue.setOnClickListener {
            findNavController().navigate(
                AudioBooksFragmentDirections.actionAudioBooksFragmentToAudioTestFragment(
                    currentPos, audioListenedTo, AUDIO_BOOKS, binding.chronometer.text.toString()
                )
            )

            binding.chronometer.stop()
            viewModel.pause()
            visualizerBar.release()

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.releasePlayer()
    }

}

