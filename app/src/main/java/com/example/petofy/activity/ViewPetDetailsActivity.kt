package com.example.petofy.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.petofy.R
import com.example.petofy.fragments.bashboardfragments.ViewPetDetailsFragment

class ViewPetDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet)
        loadFragment(ViewPetDetailsFragment())


    }


    private fun loadFragment(fragment: Fragment) {
        val transactionManger = supportFragmentManager
        val fragmentTransaction = transactionManger.beginTransaction()
        fragmentTransaction.replace(R.id.petContainer, fragment)
        fragmentTransaction.addToBackStack("my_fragment")
        fragmentTransaction.commit()
    }
}