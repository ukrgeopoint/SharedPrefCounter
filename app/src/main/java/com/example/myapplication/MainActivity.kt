package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var counter = 0
    var pref: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvResult = findViewById<TextView>(R.id.tvResult)
        val btnCount = findViewById<Button>(R.id.addNumber)

        pref = getSharedPreferences("Table", Context.MODE_PRIVATE)
        counter = pref?.getInt("counter", 0)!!
        tvResult.text = counter.toString()

        btnCount.setOnClickListener {
            counter++
            tvResult.text = counter.toString()
        }
    }

    private fun saveResult(result: Int) {
        val editor = pref?.edit()
        editor?.putInt("counter", result)
        editor?.apply()
    }

    override fun onDestroy() {
        super.onDestroy()
        saveResult(counter)
    }
}