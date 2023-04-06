package com.example.petofy.Classes

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager

class ConnectivityReceiver(private val listenet: CheckConnection) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val connectivityManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        if (networkInfo != null && networkInfo.isConnected) {
           listenet.isConnectedToInternet(true)
        } else {
            listenet.isConnectedToInternet(false)
        }

    }
}

interface CheckConnection {
    fun isConnectedToInternet(isConnected: Boolean)
}