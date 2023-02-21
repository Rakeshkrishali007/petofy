package com.example.petofy

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.petofy.databinding.ActivitySplashBinding

class Splash_Activity : AppCompatActivity() {
    lateinit var binding:ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("splash","splash is running")


        val intent = Intent(this@Splash_Activity, Home::class.java)
        startActivity(intent)
        finish()
    }
}