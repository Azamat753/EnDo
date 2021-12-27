package com.example.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words_table")
data class GrammarReadModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    var themeTitle: String,
    var compositionRules: String,
    var examples: String,
)