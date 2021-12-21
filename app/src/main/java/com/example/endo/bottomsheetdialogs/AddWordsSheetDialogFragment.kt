package com.example.endo.bottomsheetdialogs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.core.base.BaseBottomSheetDialog
import com.example.endo.R
import com.example.endo.databinding.FragmentAddWordsSheetDiaolgBinding

class AddWordsSheetDialogFragment :
    BaseBottomSheetDialog<FragmentAddWordsSheetDiaolgBinding>(FragmentAddWordsSheetDiaolgBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
