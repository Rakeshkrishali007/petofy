package com.example.petofy.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.petofy.databinding.ActivitySplashBinding


class Splash_Activity : AppCompatActivity() {
    lateinit var binding:ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val intent = Intent(this@Splash_Activity, Home_activity::class.java)
            startActivity(intent)
            finish()
        }, 3000)

    }
}