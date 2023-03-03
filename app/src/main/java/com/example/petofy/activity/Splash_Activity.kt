package com.example.petofy.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.petofy.databinding.ActivitySplashBinding
import com.example.petofy.fragments.bashboardfragments.Home_Fragment

public lateinit var shrd: SharedPreferences


class Splash_Activity : AppCompatActivity() {
    lateinit var binding:ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashBinding.inflate(layoutInflater)
        shrd=getSharedPreferences("demo", MODE_PRIVATE)
        setContentView(binding.root)
        Log.d("spl","${shrd.getString("valid","null")}")
        Log.d("spltoken","$token")
        if(shrd.getString("valid",null)!=null )
        {

            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                val intent=Intent(this@Splash_Activity,LogIn_Activity::class.java)
                startActivity(intent)
                finish()
            }, 3000)

        }
        else
        {
            val intent=Intent(this@Splash_Activity,LogIn_Activity::class.java)
            startActivity(intent)
        }
      /*
*/

    }
}