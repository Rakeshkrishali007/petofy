package com.example.petofy.fragments.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.petofy.R
import com.example.petofy.databinding.FragmentViewPetDetailsBinding

class ViewPetDetailsFragment : Fragment(R.layout.fragment_view_pet_details) {

    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentViewPetDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            binding = FragmentViewPetDetailsBinding.inflate(layoutInflater)
            binding.backPressed?.setOnClickListener()
            {
                activity?.onBackPressed()
            }


        return binding.root
    }


}