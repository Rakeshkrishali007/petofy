package com.example.petofy.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.petofy.R

import com.example.petofy.databinding.ActivityMyStaffBinding
import com.example.petofy.fragments.bashboardfragments.AddStafFragment
import com.example.petofy.fragments.bashboardfragments.MyStaffFragment
import com.example.petofy.fragments.bashboardfragments.ViewPetDetails
import kotlin.collections.ArrayList

var status = false

class MyStaffActivity : AppCompatActivity() {
    lateinit var binding: ActivityMyStaffBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMyStaffBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadFragment(ViewPetDetails())

    }

    private fun loadFragment(fragment: Fragment) {
        val transactionManger = supportFragmentManager
        val fragmentTransaction = transactionManger.beginTransaction()
        fragmentTransaction.replace(R.id.myStaffContainer, fragment)
        fragmentTransaction.addToBackStack("my_fragment")
        var count=transactionManger.backStackEntryCount
       /* for(i in 0 until count-1)
        {
            transactionManger.popBackStack()
        }*/
        fragmentTransaction.commit()


    }



}