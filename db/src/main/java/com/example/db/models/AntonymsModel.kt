package com.example.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "antonyms_table")
data class AntonymsModel (
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    var antonymsInEnglish: String,
    var antonymsWord: String,
    var antonyms: String,
    var category:String,
)