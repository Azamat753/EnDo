package com.example.endo.bottomsheetdialogs

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

}