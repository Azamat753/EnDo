package com.example.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words_table")
data class WordsModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    var wordInEnglish: String,
    var wordInRussian: String,
    var category:String,
    var image:String
)