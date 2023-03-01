package com.example.petofy.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.petofy.R
import com.example.petofy.adapters.ViewPagerAdapter
import com.example.petofy.databinding.ActivityHomeBinding

class Home_activity : AppCompatActivity() {
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
        val text=listOf(
            "Manage all your patience on the go",
            "Manage appointments",
            "Allow instant access to patient reports"
        )
        val adapter= ViewPagerAdapter(image,text)
        binding.viewPager.adapter=adapter
        binding.btnLogin.setOnClickListener()
        {

            val intent=Intent(this@Home_activity,LogIn_Activity::class.java)
            startActivity(intent)
            finish()

        }
        binding.btnGetStarted.setOnClickListener()
        {
            val intent=Intent(this@Home_activity, GetStarted_activity::class.java)
            startActivity(intent)
        }


    }
}