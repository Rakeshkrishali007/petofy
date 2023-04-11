package com.example.petofy.fragments.Fragments

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.petofy.R
import com.example.petofy.databinding.FragmentPetProfileBinding
import java.util.*


class PetProfileFragment : Fragment(R.layout.fragment_pet_profile) {

    lateinit var binding:FragmentPetProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPetProfileBinding.inflate(layoutInflater)
        binding.checkbox.setOnClickListener()
        {
            if(binding.checkbox.isChecked)
            {
                binding.txtCalender.visibility = View.INVISIBLE
                binding.txtDayAge.visibility  = View.VISIBLE
            }
            else
            {
                binding.txtDayAge.visibility = View.INVISIBLE
                binding.txtCalender.visibility = View.VISIBLE
            }
        }

        val status = arrayOf( "Dog", "Cat", "Other")
        val status2 = arrayOf("Day", "Week", "Month", "Year")
        val petDateAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, status2)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, status)

        binding.AutoCompleteTextview.setAdapter(adapter)
        binding.AutoCompleteTextview2.setAdapter(petDateAdapter)


        binding.datePicker.setOnClickListener()
        {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            var month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)


            val dpd = DatePickerDialog(this@PetProfileFragment.requireContext(), DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                Log.d("date", "$dayOfMonth , $monthOfYear , $year")
                var mutablemonth = monthOfYear + 1
                var date = "$dayOfMonth/$mutablemonth/$year"
                setDate(date)
            }, year, month, day)

            dpd.getDatePicker().setMaxDate(System.currentTimeMillis());
            dpd.show()
        }
        return binding.root
    }

    private fun setDate(date: String) {
        binding.datePicker.setText(date)

    }

}