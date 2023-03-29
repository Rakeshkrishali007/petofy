package com.example.petofy.activity

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.petofy.databinding.ActivitySplashBinding

public lateinit var shrd: SharedPreferences


class Splash_Activity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        shrd = getSharedPreferences("demo", MODE_PRIVATE)
        setContentView(binding.root)
        Log.d("spl", "${shrd.getString("valid", "null")}")
        Log.d("spltoken", "$token")

        if (shrd.getString("valid", null) != null) {

            val animator = ObjectAnimator.ofPropertyValuesHolder(
                binding.imageView,
                PropertyValuesHolder.ofFloat(View.SCALE_X, 0.0f, 2.0f),
                PropertyValuesHolder.ofFloat(View.SCALE_Y, 0.0f, 2.0f)
            )
            animator.duration = 5000 // 5 seconds
            animator.start()
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                val intent = Intent(this@Splash_Activity, DashBoardActivity::class.java)
                startActivity(intent)
                finish()
            }, 3000)

        } else {
            val intent = Intent(this@Splash_Activity, LogIn_Activity::class.java)
            startActivity(intent)
            finish()
        }


    }
}