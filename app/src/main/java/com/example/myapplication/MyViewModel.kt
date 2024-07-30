package com.example.myapplication

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    var counter = 0
    var pref: SharedPreferences? = null

    private fun saveResult(res: Int, pref: SharedPreferences) {
        val editor = pref?.edit()
        editor?.putInt("counter", res)
        editor?.apply()
    }
}