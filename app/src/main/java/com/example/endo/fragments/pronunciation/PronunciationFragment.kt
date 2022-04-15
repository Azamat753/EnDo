package com.example.endo.fragments.pronunciation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.core.base.BaseFragment
import com.example.core.extensions.getBackStackData
import com.example.endo.databinding.FragmentPronunciationBinding
import com.example.endo.viewmodels.PronunciationViewModel
import dagger.hilt.android.AndroidEntryPoint


const val SPEECH_REQUEST_CODE = 102

@AndroidEntryPoint
class PronunciationFragment :
    BaseFragment<FragmentPronunciationBinding>(FragmentPronunciationBinding::inflate) {

    private var speakResult: String? = null
    private val viewModel by viewModels<PronunciationViewModel>()
    private var nextPronunciation = 0
    private val listNotCorrect = ArrayList<Boolean>()
    private var boolean = false
    private var lastTime: Long? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.chronometer.start()
        changePronunciation()
        changeViewVisibility()
        binding.btn.setOnClickListener {
            askSpeechInput()
            binding.tvVy.visibility = View.VISIBLE
            binding.tvTextName.visibility = View.VISIBLE
            binding.tvView.visibility = View.GONE
            binding.icVolume.visibility = View.GONE
            binding.tvTextBottom.visibility = View.GONE
            binding.btnAccept.visibility = View.VISIBLE

        }
    }

    private fun changePronunciation() {
        binding.tvTextview.text = viewModel.getPronunciations()[0].pronunciation
        getBackStackData<Boolean>("next") {
            lastTime?.let { time ->
                binding.chronometer.base =
                    (binding.chronometer.base + SystemClock.elapsedRealtime() - time)
            }
            binding.chronometer.start()
            if (it) {
                if (boolean) {
                    nextPronunciation++
                }
                binding.tvTextview.text =
                    viewModel.getPronunciations()[nextPronunciation].pronunciation
            }
        }
    }

    private fun changeViewVisibility() = with(binding) {
        getBackStackData<Boolean>("next") {
            if (it) {
                tvVy.visibility = View.GONE
                tvTextName.visibility = View.GONE
                tvView.visibility = View.VISIBLE
                icVolume.visibility = View.VISIBLE
                tvTextBottom.visibility = View.VISIBLE
                btnAccept.visibility = View.GONE
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val result: ArrayList<String>? =
                data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            speakResult = result?.get(0).toString()
            binding.tvTextName.text = result?.get(0).toString()
        }
    }

    private fun askSpeechInput() {
        if (SpeechRecognizer.isRecognitionAvailable(requireContext())) {
        } else {
            val i = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            i.putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
            )
            i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US")
            i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say something!")
            startActivityForResult(i, SPEECH_REQUEST_CODE)
        }
        binding.btnAccept.setOnClickListener {
            lastTime = SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            viewModel.getPronunciations().apply {
                if (speakResult == get(nextPronunciation).pronunciation) {
                    boolean = true
                    listNotCorrect.add(boolean)
                    findNavController().navigate(
                        PronunciationFragmentDirections.actionPronunciationFragmentToPronunciationSheetDialogFragment(
                            listNotCorrect.toTypedArray().toBooleanArray(),
                            binding.chronometer.text.toString()
                        )
                            .setIsCorrect(true)
                            .setLastPosition(nextPronunciation.plus(1))
                    )
                } else {
                    boolean = false
                    listNotCorrect.add(boolean)
                    findNavController().navigate(
                        PronunciationFragmentDirections.actionPronunciationFragmentToPronunciationSheetDialogFragment(
                            listNotCorrect.toTypedArray().toBooleanArray(), ""
                        )
                            .setIsCorrect(false)
                            .setLastPosition(nextPronunciation.plus(-1))
                    )
                }
            }
        }

    }
}
