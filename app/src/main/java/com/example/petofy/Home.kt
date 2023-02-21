package com.example.petofy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.petofy.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {
    lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val image= listOf(
            R.drawable.dogs,
            R.drawable.man,
            R.drawable.documemt
        )
        val adapter=ViewPagerAdapter(image)
        binding.viewPager.adapter=adapter

    }
}