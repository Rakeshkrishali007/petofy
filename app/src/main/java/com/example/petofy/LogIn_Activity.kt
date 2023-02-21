package com.example.petofy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.petofy.databinding.ActivityLogInBinding

class LogIn_Activity : AppCompatActivity() {
    public lateinit var binding:ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}