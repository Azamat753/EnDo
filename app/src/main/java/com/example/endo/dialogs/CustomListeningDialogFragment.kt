package com.example.endo.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.endo.R
import com.example.endo.databinding.FragmentListeningBottomSheetDialogBinding
import com.example.endo.viewmodels.MovieViewModel

class CustomListeningDialogFragment : DialogFragment(
) {
    private lateinit var binding: FragmentListeningBottomSheetDialogBinding
    private val viewModel: MovieViewModel by activityViewModels()
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
        btnContinue.setOnClickListener {
            dismiss()
            viewModel.putCount(viewModel.getCount()!!)
            findNavController().navigate(R.id.audioTestFragment)


        }

        btnHaveARest.setOnClickListener {
            dismiss()
            findNavController().navigate(R.id.audioResultFragment)

        }

    }

}