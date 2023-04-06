package com.example.petofy.fragments.bashboardfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.petofy.R
import com.example.petofy.databinding.FragmentPetBinding


class PetProfileFragment : Fragment(R.layout.fragment_pet_profile) {

    lateinit var binding: FragmentPetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPetBinding.inflate(layoutInflater)
        return binding.root
    }

}