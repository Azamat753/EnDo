package com.example.core.utils

import android.content.SharedPreferences
import javax.inject.Inject

class CacheManager @Inject
constructor(
    private val sharedPreferences: SharedPreferences
) {
    val isShow: Boolean = sharedPreferences.getBoolean(IS_SHOW, false)
    val userImage :String = sharedPreferences.getString(USER_IMAGE,"").toString()

    fun setBoardShowed() {
        sharedPreferences.edit().putBoolean(IS_SHOW, true).apply()
    }
    fun saveUserImage(image:String){
        sharedPreferences.edit().putString(USER_IMAGE,image).apply()
    }

    companion object {
        private const val IS_SHOW = "isShow"
        private const val USER_IMAGE = "user_image"
    }
}