package com.example.endo.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.endo.databinding.FragmentListeningBottomSheetDialogBinding

class ListeningBottomSheetDialogFragment : DialogFragment(
) {
    private lateinit var binding: FragmentListeningBottomSheetDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListeningBottomSheetDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() = with(binding) {
        btnContinue.setOnClickListener{
            dismiss()

        }

        btnHaveARest.setOnClickListener{

        }

    }

}