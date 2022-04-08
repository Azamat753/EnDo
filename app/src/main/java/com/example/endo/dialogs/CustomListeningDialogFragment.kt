package com.example.endo.dialogs

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
import com.example.endo.R
import com.example.endo.common.Constants.AUDIO_BOOKS
import com.example.endo.common.Constants.MOVIES
import com.example.endo.common.Constants.MUSIC
import com.example.endo.databinding.FragmentListeningBottomSheetDialogBinding

class CustomListeningDialogFragment : DialogFragment(
) {

    private lateinit var binding: FragmentListeningBottomSheetDialogBinding
    private val args: CustomListeningDialogFragmentArgs by navArgs()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog?.setCancelable(false)
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = FragmentListeningBottomSheetDialogBinding.inflate(LayoutInflater.from(context))
        val builder = AlertDialog.Builder(activity)
                .setView(binding.root)
                .create()
        builder.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return builder
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        setupViews()

    }

    private fun setupViews() {
        viewsReplacementDependingOnArgs()
    }


    private fun viewsReplacementDependingOnArgs() {
        if (!args.rightOrNot) {
            binding.tvRightOrNot.text = "Попробуем еще раз?"
            binding.imRightOrNot.setImageResource(R.drawable.mistake_icon)
        }
    }


    private fun initListeners() = with(binding) {
        btnContinue.setOnClickListener {
            when (args.whichAudioWasListenedTo) {
                MUSIC -> {
                    findNavController().navigate(
                            CustomListeningDialogFragmentDirections.actionCustomListeningDialogFragmentToMusicFragment(
                                    args.positionFromAudioTest
                            )
                    )
                }
                MOVIES -> {
                    findNavController().navigate(
                            CustomListeningDialogFragmentDirections.actionCustomListeningDialogFragmentToMovieFragment(
                                    args.positionFromAudioTest
                            )
                    )
                }
                AUDIO_BOOKS -> {
                    findNavController().navigate(
                            CustomListeningDialogFragmentDirections.actionCustomListeningDialogFragmentToAudioBooksFragment(
                                    args.positionFromAudioTest
                            )
                    )

                }
            }


        }

        btnHaveARest.setOnClickListener {
            dismiss()
            findNavController().navigate(
                    CustomListeningDialogFragmentDirections.actionCustomListeningDialogFragmentToAudioResultFragment(
                            args.totalAudioListened,
                            args.timeFromTests,
                            args.amountOfRightAnswers,
                            args.amountOfMistakes
                    )
            )


        }


    }


}