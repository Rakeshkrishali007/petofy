package com.example.petofy.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.petofy.R
import com.example.petofy.databinding.ActivityPasswordChangedBinding

lateinit var binding:ActivityPasswordChangedBinding
class PasswordChangedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPasswordChangedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.back.setOnClickListener()
        {
            onBackPressed()
        }

    }
}