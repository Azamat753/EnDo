package com.example.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "achievement_table")
data class AchievementsModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    var rank: String,
    var condition: String,
    var currentAmountForProgressBar:Int,
    var maxAmountForProgressBar:Int,
    var image:String
)