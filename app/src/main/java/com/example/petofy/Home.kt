package com.example.petofy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Log.d("Home","home running")
    }
}