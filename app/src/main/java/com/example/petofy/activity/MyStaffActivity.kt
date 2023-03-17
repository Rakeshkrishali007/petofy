package com.example.petofy.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.petofy.adapters.MyStaffAdapter
import com.example.petofy.apiRequest.MyStaffRequest
import com.example.petofy.apiRequest.MyStaffRequestData
import com.example.petofy.apiResponse.MyStaffResponse
import com.example.petofy.apiResponse.MyStaffResponseStaffDetail
import com.example.petofy.databinding.ActivityMyStaffBinding
import com.example.petofy.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyStaffActivity : AppCompatActivity() {
    lateinit var binding: ActivityMyStaffBinding
    lateinit var adapter: MyStaffAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMyStaffBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getStaff("0")
    }
    private fun getStaff(page: String) {
        val token = shrd.getString("valid", "null")
        Log.d("stafftoken","${token}")
        RetrofitClient.staffintance.getStaffList(token, MyStaffRequest(MyStaffRequestData(page,"10",""))).enqueue(object : Callback<MyStaffResponse?> {
            override fun onResponse(
                call: Call<MyStaffResponse?>,
                response: Response<MyStaffResponse?>
            ) {
               if(response.body()!=null)
               {
                   var staffDetail= response.body()?.data?.staffDetail
                   Log.d("staffres","${staffDetail}")
                   adapter=MyStaffAdapter(staffDetail as ArrayList<MyStaffResponseStaffDetail>)
                   binding.recycleView.adapter=adapter
                   Log.d("adapter","${binding.recycleView.adapter}")

               }
            }
            override fun onFailure(call: Call<MyStaffResponse?>, t: Throwable) {
              Toast.makeText(this@MyStaffActivity,"error",Toast.LENGTH_SHORT).show()
            }
        })

    }
}