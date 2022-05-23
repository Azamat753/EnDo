package com.example.db.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "dictionary_category_table")
data class DictionaryCategoryModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    var categoryName: String,
    var wordsAmount: Int = 0
) : Parcelable