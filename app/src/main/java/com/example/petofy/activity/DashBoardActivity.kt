package com.example.petofy.activity

import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.petofy.Classes.ConnectivityReceiver
import com.example.petofy.R
import com.example.petofy.databinding.ActivityDashBoardBinding
import com.example.petofy.fragments.bashboardfragments.*

public lateinit var fragment: Fragment
public var bool = false

class DashBoardActivity : AppCompatActivity() {
    lateinit var binding: ActivityDashBoardBinding
    val connectivityReceiver = ConnectivityReceiver(this)
    var connected = false
    var  fragment2 = null

    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(connectivityReceiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(connectivityReceiver)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(connectivityReceiver.isConnected(this))
        {
            loadFragment(Home_Fragment())
        }





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
