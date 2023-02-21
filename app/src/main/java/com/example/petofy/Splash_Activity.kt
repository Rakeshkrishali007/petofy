package com.example.petofy

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Splash_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Log.d("splash","splash is running")
        val image= listOf(
            R.drawable.dogs,
            R.drawable.man,
            R.drawable.documemt
        )
        val adapter=ViewPagerAdapter(image)
        binding.viewPager.adapter=adapter
        val intent = Intent(this@Splash_Activity, Home::class.java)
        startActivity(intent)
    }
}