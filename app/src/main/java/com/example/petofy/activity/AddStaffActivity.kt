package com.example.petofy.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.petofy.R
import com.example.petofy.apiRequest.AddStaffData
import com.example.petofy.apiRequest.AddStaffRequest
import com.example.petofy.apiResponse.AddStaffResponse
import com.example.petofy.databinding.ActivityAddStaffBinding
import com.example.petofy.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddStaffActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddStaffBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddStaffBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val status = arrayOf("Dr.", "Mrs.", "Mr.", "Miss.")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, status)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter=adapter

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                Toast.makeText(this@AddStaffActivity, "Selected item: $selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        binding.addStaff.setOnClickListener()
        {
            addNewStaff()
        }




    }

    private fun addNewStaff() {

        var res=""
        val token = shrd.getString("valid", "null")
        val firstname=binding.firstname.text.toString()
        val lastname=binding.lastname.text.toString()
        val email=binding.email.text.toString()
        val password=binding.password.text.toString()
        val confirmpassword=binding.confirmpassword.text.toString()
        val phone=binding.phonenumber.text.toString()
        val quli=binding.qualification.text.toString()
        val regis=binding.resgisnumer.text.toString()
        val ini=binding.spinner.selectedItem.toString()
      //  confirmpassword,"false",email,firstname,ini,lastname,password,phone,quli,regis
        RetrofitClient.addstaffintance.addStaff(token, AddStaffRequest(AddStaffData("123321","false","email@gmail.com","fifa","Dr.","word","123321","9879876545","kjfkj","kfjkdjfks;j"))).enqueue(object : Callback<AddStaffResponse?> {
            override fun onResponse(
                call: Call<AddStaffResponse?>,
                response: Response<AddStaffResponse?>
            ) {
                if(response.body()!=null)
                {

                Toast.makeText(this@AddStaffActivity,"${response.body()!!.response.responseMessage}",Toast.LENGTH_SHORT).show()
                    res= response.body()!!.response.responseMessage

                }


            }

            override fun onFailure(call: Call<AddStaffResponse?>, t: Throwable) {
                Log.d("res","error")
            }
        })
    }
}