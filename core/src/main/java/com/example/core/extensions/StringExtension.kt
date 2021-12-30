package com.example.core.extensions

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.Window

fun String.removeBrackets(): String {
    return this.replace("[", "").replace("]", "")
}
fun Context.getDialog(layout: Int): Dialog {
    val inflater: LayoutInflater = LayoutInflater.from(this)
    val view: View = inflater.inflate(layout, null)
    val dialog = Dialog(this)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setContentView(view)
    dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    return dialog
}