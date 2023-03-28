package com.example.petofy.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import com.example.petofy.R
import com.example.petofy.databinding.ActivityIsSearchedBinding

class IsSearched : AppCompatActivity() {
    lateinit var binding: ActivityIsSearchedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityIsSearchedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backPressed.setOnClickListener()
        {
            onBackPressed()
        }

    }
}