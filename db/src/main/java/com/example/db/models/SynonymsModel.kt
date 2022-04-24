package com.example.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "synonyms_table")
data class SynonymsModel (
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    var synonymsInEnglish: String,
    var synonymsWord: String,
    var synonyms: String,
    var category:String,
)