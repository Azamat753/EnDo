package com.example.endo.bottomsheetdialogs

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.core.extensions.navigateSafely
import com.example.core.extensions.setBackStackData
import com.example.endo.R
import com.example.endo.databinding.FragmentPronunciationSheetDialogBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PronunciationSheetDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentPronunciationSheetDialogBinding
    private val args by navArgs<PronunciationSheetDialogFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.setCancelable(false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = FragmentPronunciationSheetDialogBinding.inflate(LayoutInflater.from(context))
        val builder = AlertDialog.Builder(activity)
            .setView(binding.root)
            .create()
        builder.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        binding.apply {
            if (args.isCorrect) {
                tvNext.text = "Идем дальше?"
                ivIcon.load(R.drawable.vp)
            } else {
                tvNext.text = "Попробуем еще раз?"
                ivIcon.load(R.drawable.vector)
            }
        }
        setupButtonsClickListener()
        return builder
    }

    private fun setupButtonsClickListener() {
        binding.applyButton.setOnClickListener {
            findNavController().navigate(
                PronunciationSheetDialogFragmentDirections.actionPronunciationSheetDialogFragmentToColloquialFragment()
            )
        }
        binding.applyBtn.setOnClickListener {
            if (args.lastPosition == 9) {
                findNavController().navigateSafely(
                    PronunciationSheetDialogFragmentDirections
                        .actionPronunciationSheetDialogFragmentToResultFragment(
                            args.listNotCorrect,
                            args.time
                        )
                )
            } else {
                setBackStackData("next", data = true, doBack = true)
            }
        }
    }
}
