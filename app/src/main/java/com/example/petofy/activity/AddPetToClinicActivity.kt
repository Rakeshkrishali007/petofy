package com.example.petofy.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.petofy.R
import com.example.petofy.fragments.bashboardfragments.AddPetToClinicFragment

class AddPetToClinicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_pet_to_clinic)
        loadFragment(AddPetToClinicFragment())
    }




    private fun loadFragment(fragment: Fragment) {
        val transactionManger = supportFragmentManager
        val fragmentTransaction = transactionManger.beginTransaction()
        fragmentTransaction.replace(R.id.petContainer, fragment)
        fragmentTransaction.addToBackStack("my_fragment")
        fragmentTransaction.commit()
    }
}