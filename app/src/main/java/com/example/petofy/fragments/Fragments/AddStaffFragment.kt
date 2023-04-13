package com.example.petofy.fragments.Fragments

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.petofy.R
import com.example.petofy.activity.shrd
import com.example.petofy.apiRequest.AddStaffData
import com.example.petofy.apiRequest.AddStaffRequest
import com.example.petofy.apiResponse.AddStaffResponse
import com.example.petofy.databinding.FragmentAddStaffBinding
import com.example.petofy.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddStafFragment : Fragment(R.layout.fragment_add_staff) {


    lateinit var binding: FragmentAddStaffBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddStaffBinding.inflate(layoutInflater)
        hasData = false
        binding.backPressed.setOnClickListener()
        {
          activity?.onBackPressed()
        }
        val status = arrayOf("Dr.", "Mrs.", "Mr.", "Miss.")

        val adapter= ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, status)
        binding.AutoCompleteTextview.setAdapter(adapter)


        binding.btnAddStaff.setOnClickListener()
        {


            if (isValid()) {
                binding.progressBar.visibility = View.VISIBLE
                addNewStaff()
            }


        }


        return binding.root
    }

    fun isValid(): Boolean {
        if(binding.firstname.text?.isEmpty()==true&&binding.lastname.text?.isEmpty()==true&&
            binding.password.text?.isEmpty()==true&&binding.confirmpassword.text?.isEmpty()==true&&binding.email.text?.isEmpty()==true&&binding.qualification.text?.isEmpty()==true&&binding.resgisnumer.text?.isEmpty()==true)
        {
            Toast.makeText(this@AddStafFragment.requireContext(), "Fill all the details", Toast.LENGTH_SHORT).show()
            return  false
        }
        if (binding.firstname.text?.isEmpty() == true) {
           binding.firstname.setError("First name require")
            return false
        }
        if (binding.lastname.text?.isEmpty() == true) {
            binding.lastname.setError("Last name require")
            return false
        }
        if (binding.email.text?.isEmpty() == true) {
            binding.email.setError("Email require")
            return false
        }
        if (binding.password.text?.isEmpty() == true && binding.confirmpassword.text?.isEmpty() == true) {
           binding.password.setError("Password require")
            binding.confirmpassword.setError("password require")
            return false
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(binding.email.text.toString().trim()).matches()) {
            binding.email.setError("Invalid email")
            return false
        }
        if (binding.password.text.toString() != binding.confirmpassword.text.toString()) {

            binding.confirmpassword.setError("password must be same")
            return false
        }

        if(binding.phonenumber.text.toString().isEmpty())
        {
            binding.phonenumber.setError("phone Number require")
            return  false
        }
        if(binding.phonenumber.text?.count()!! > 10)
        {
            Log.d("count","${binding.phonenumber.text!!.count()}")
            binding.phonenumber.setError("Invalid Number")
            return  false
        }
        if (binding.qualification.text?.isEmpty() == true) {
           binding.qualification.setError("Fill")
            return false
        }
        if (binding.resgisnumer.text?.isEmpty() == true) {
           binding.resgisnumer.setError("Fill")
            return false
        }

        return true
    }

    private fun addNewStaff() {

        var res = ""
        val token = shrd.getString("valid", "null")
        val firstname = binding.firstname.text.toString()
        val lastname = binding.lastname.text.toString()
        val email = binding.email.text.toString()
        val password = binding.password.text.toString()
        val confirmpassword = binding.confirmpassword.text.toString()
        val phone = binding.phonenumber.text.toString()
        val quli = binding.qualification.text.toString()
        val regis = binding.resgisnumer.text.toString()

        RetrofitClient.apiInterface.addStaff(
            token,
            AddStaffRequest(
                AddStaffData(
                    confirmpassword.toString(),
                    "false",
                    email.toString(),
                    firstname.toString(),
                    "Dr.",
                    lastname.toString(),
                    password.toString(),
                    phone.toString(),
                    quli.toString(),
                    regis.toString()
                )
            )
        ).enqueue(object : Callback<AddStaffResponse?> {
            override fun onResponse(
                call: Call<AddStaffResponse?>,
                response: Response<AddStaffResponse?>
            ) {
                if (response.body() != null) {

                    binding.progressBar.visibility = View.INVISIBLE
                    Toast.makeText(
                        this@AddStafFragment.requireContext(),
                        "${response.body()!!.response.responseMessage}",
                        Toast.LENGTH_SHORT
                    ).show()


                } else {
                    Log.d("res", "null")
                }


            }

            override fun onFailure(call: Call<AddStaffResponse?>, t: Throwable) {
                Toast.makeText(
                    this@AddStafFragment.requireContext(),
                    "Something went wrong",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        })
    }

}