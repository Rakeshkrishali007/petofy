package com.example.petofy.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import com.example.petofy.Classes.CheckConnection
import com.example.petofy.R
import com.example.petofy.databinding.ActivityPasswordChangedBinding

lateinit var binding:ActivityPasswordChangedBinding
class PasswordChangedActivity : AppCompatActivity(),CheckConnection {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPasswordChangedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.changePassword.setOnClickListener()
        {
            val view = this.currentFocus
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
        }
        binding.back.setOnClickListener()
        {
            onBackPressed()
        }

    }

    override fun isConnectedToInternet(isConnected: Boolean) {

    }
}