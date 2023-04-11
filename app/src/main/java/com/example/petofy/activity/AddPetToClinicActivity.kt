package com.example.petofy.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.petofy.R
import com.example.petofy.fragments.Fragments.AddPetToClinicFragment

class AddPetToClinicActivity : AppCompatActivity() {
    private  lateinit var  navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_pet_to_clinic)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.addPetClinicFragment)  as NavHostFragment
        navController = navHostFragment.navController


    }





}