package com.example.core

import androidx.fragment.app.FragmentActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

object CommonFunction {
    fun showBottomSheet(bottomSheetDialog: BottomSheetDialogFragment,fragmentActivity: FragmentActivity,tag:String) {
        bottomSheetDialog.show(fragmentActivity.supportFragmentManager, tag)
    }
}