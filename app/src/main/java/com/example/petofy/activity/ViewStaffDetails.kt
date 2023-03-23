package com.example.petofy.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.petofy.R
import com.example.petofy.databinding.ActivityViewStaffDetailsBinding

class ViewStaffDetails : AppCompatActivity() {
    lateinit var binding: ActivityViewStaffDetailsBinding
    lateinit var  fullname:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityViewStaffDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backPressed.setOnClickListener()
        {
            onBackPressed()
        }
        val firstname=intent.getStringExtra("Firstname")
        val lastname=intent.getStringExtra("Lirstname")
        val email=intent.getStringExtra("Email")
        val study=intent.getStringExtra("Study")
        val number =intent.getStringExtra("PhoneNumber")
        if(number==null)
        {
            binding.numberView.visibility=View.INVISIBLE
        }
        if(study==null)
        {
            binding.studyView.visibility=View.INVISIBLE
        }
        if(lastname!=null)
         fullname=firstname+" "+lastname
        else
        {
            if (firstname != null) {
                fullname= firstname
            }
        }
        Log.d("fullname","${fullname}")
        binding.email.text=email.toString()
        binding.phone.text=number.toString()
        binding.study.text=study.toString()
        binding.name.text=fullname.toString()

    }
}