package com.example.petofy.Classes

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.ConnectivityManager
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.petofy.R
import com.example.petofy.activity.DashBoardActivity
import com.example.petofy.fragments.Fragments.Home_Fragment

class ConnectivityReceiver(private  val context: DashBoardActivity) : BroadcastReceiver() {

    var connected = false
    fun isConnected(context: Context?):Boolean
    {
        val connectivityManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        if(networkInfo?.isConnected == true)
        {
            return  true
        }

        return  false
    }
     fun ShowInternetConnectionDailog(isConnected: Boolean) {

        connected= isConnected
        val view = LayoutInflater.from(context)
            .inflate(R.layout.custom_internet_dialog_alert, null)
        view.setBackgroundColor(Color.TRANSPARENT)
        var dailog = AlertDialog.Builder(context).create()
        dailog.setCancelable(false)

        dailog.setView(view)
        val tryAgain = view.findViewById<Button>(R.id.btn_try_again)

        if (!connected)
        {
            dailog.show()
        }

        tryAgain.setOnClickListener()
        {

            if(connected) {
                dailog.dismiss()
                loadFragment(Home_Fragment())
            }
            else
            {
                Toast.makeText(context, "Turn on internet connection", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun loadFragment(fragment: Fragment) {
        val transactionManger = context.supportFragmentManager
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


    override fun onReceive(context: Context?, intent: Intent?) {
        val connectivityManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        if (networkInfo != null && networkInfo.isConnected) {
          ShowInternetConnectionDailog(true)
        }
        else
        {
           ShowInternetConnectionDailog(false)
        }

    }
}

