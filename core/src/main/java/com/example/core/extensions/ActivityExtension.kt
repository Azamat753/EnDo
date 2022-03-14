package com.example.core.extensions

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.core.base.showToast


fun Activity.requireAudioPermission(context: Context, activity: Activity) {
    if (ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.RECORD_AUDIO
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        ActivityCompat.requestPermissions(
            activity,
            Array(1) { Manifest.permission.RECORD_AUDIO },
            0
        )
        context.showToast("Permission has been granted")
    }


}

