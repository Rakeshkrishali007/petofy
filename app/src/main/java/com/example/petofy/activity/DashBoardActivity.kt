package com.example.petofy.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.petofy.R
import com.example.petofy.databinding.ActivityDashBoardBinding
import com.example.petofy.fragments.bashboardfragments.*

public lateinit var fragment: Fragment
public var bool = false

class DashBoardActivity : AppCompatActivity() {
    lateinit var binding: ActivityDashBoardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadFragment(Home_Fragment())

        val fragment=Home_Fragment.newInstance("hello", "hello")

        bool = true
        binding.bnView.setOnNavigationItemSelectedListener {null
            when (it.itemId) {
                R.id.nv_home -> {
                    if (!bool) {

                        loadFragment(Home_Fragment())
                        if (fragment != null) {
                            //fragment.setViewModelData()
                        } else {
                                Log.d("null","mkdjfkjd")
                        }
                        hasData = false
                    }
                    true
                }
                R.id.nv_dog -> {
                    bool = false
                    loadFragment(Pet_Fragment())
                    hasData = false

                    true
                }
                R.id.nv_date -> {
                    bool = false
                    loadFragment(CalenderFragment())
                    hasData = false
                    true
                }
                R.id.nv_user -> {
                    bool = false
                    loadFragment(User_Fragment())
                    hasData = false
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transactionManger = supportFragmentManager
        val fragmentTransaction = transactionManger.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment)
        fragmentTransaction.addToBackStack("my_fragment")
        var count=transactionManger.backStackEntryCount
        for(i in 0 until count-1)
        {
            transactionManger.popBackStack()
        }
        fragmentTransaction.commit()


    }


}
