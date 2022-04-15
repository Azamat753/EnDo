package com.example.endo.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PronunciationModel(
    var isCorrect: Boolean,
    var position: Int,
) : Parcelable