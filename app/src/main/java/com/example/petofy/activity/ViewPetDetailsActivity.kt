package com.example.petofy.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.petofy.R

class ViewPetDetailsActivity : AppCompatActivity() {
    private  lateinit var  navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pet_details)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.viewPetFragment)  as NavHostFragment
        navController = navHostFragment.navController



    }



}
