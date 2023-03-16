package com.example.petofy.Classes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeFragmentViewModel : ViewModel() {

    var myPet: String = ""
    var onlineAppointment = ""
    var staff = ""

    public  fun setData(staff:String, pet:String, appoi:String)
    {

    }
    public fun showData() {
        Log.d("fun", "${myPet}${onlineAppointment}${staff}")
    }

    public fun showData2() {
        Log.d("fun2", "${myPet}${onlineAppointment}${staff}")
    }

}