package com.example.core.utils

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

object CommonFunction {
    fun showBottomSheet(
        bottomSheetDialog: BottomSheetDialogFragment,
        fragmentActivity: FragmentActivity,
        tag: String
    ) {
        bottomSheetDialog.show(fragmentActivity.supportFragmentManager, tag)
    }

    fun showCustomDialog(
        customDialog: DialogFragment,
        fragmentActivity: FragmentActivity,
        tag: String
    ) {
        customDialog.show(fragmentActivity.supportFragmentManager, tag)

    }

}