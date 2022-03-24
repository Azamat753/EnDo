package com.example.endo.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.endo.R
import com.example.endo.databinding.FragmentListeningBottomSheetDialogBinding

class CustomListeningDialogFragment : DialogFragment(
) {
    private lateinit var binding: FragmentListeningBottomSheetDialogBinding
    private val args: CustomListeningDialogFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCancelable(false)
        dialog?.window
        binding = FragmentListeningBottomSheetDialogBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() = with(binding) {
        btnContinue.setOnClickListener {
            dismiss()
            findNavController().navigate(
                CustomListeningDialogFragmentDirections.actionCustomListeningDialogFragmentToMovieFragment(
                    args.positionFromAudioTest
                )
            )


        }

        btnHaveARest.setOnClickListener {
            dismiss()
            findNavController().navigate(R.id.audioResultFragment)

        }


    }


}