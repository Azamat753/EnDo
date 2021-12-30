package com.example.core.utils

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach

object CommonFunction {
    fun showBottomSheet(bottomSheetDialog: BottomSheetDialogFragment,fragmentActivity: FragmentActivity,tag:String) {
        bottomSheetDialog.show(fragmentActivity.supportFragmentManager, tag)
    }

}