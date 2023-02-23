package com.example.petofy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.petofy.databinding.ActivityDashBoardBinding

class DashBoard : AppCompatActivity() {
    lateinit var binding: ActivityDashBoardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bnView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nv_home -> {
                    loadFragment(Home_Fragment())
                    true
                }
                R.id.nv_dog -> {
                    loadFragment(Pet_Fragment())
                    true
                }
                R.id.nv_date -> {
                    loadFragment(Calender_Fragment())
                    true
                }
                R.id.nv_user -> {
                    loadFragment(User_Fragment())
                    true
                }
                else -> false
            }
        }
    }

    private  fun loadFragment(fragment: Fragment)
    {
        val transactionManger =supportFragmentManager
        val fragmentTransaction=transactionManger.beginTransaction()
        fragmentTransaction.replace(R.id.container,fragment)
        fragmentTransaction.commit()



    }


}
