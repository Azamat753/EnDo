package com.example.endo.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer


@Parcelize
data class QuestionModel(
     var id: Int,
     val question: String
): Parcelable {

}