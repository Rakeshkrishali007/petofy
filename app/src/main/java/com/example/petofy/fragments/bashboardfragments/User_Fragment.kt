package com.example.petofy.fragments.bashboardfragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.petofy.R
import com.example.petofy.activity.LogIn_Activity
import com.example.petofy.activity.shrd
import com.example.petofy.databinding.FragmentUserBinding


class User_Fragment : Fragment(R.layout.fragment_user_) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentUserBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentUserBinding.inflate(layoutInflater)

        binding.logout.setOnClickListener()
        {
            val editor = shrd.edit()
            editor.clear().commit()
            val intent= Intent(requireActivity(),LogIn_Activity::class.java)
            startActivity(intent)
            activity?.finish()

        }
        return binding.root
    }


}