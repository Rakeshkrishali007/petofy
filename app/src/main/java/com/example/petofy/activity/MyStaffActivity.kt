package com.example.petofy.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petofy.adapters.MyStaffAdapter
import com.example.petofy.apiRequest.MyStaffRequest
import com.example.petofy.apiRequest.MyStaffRequestData
import com.example.petofy.apiResponse.MyStaffResponse
import com.example.petofy.apiResponse.MyStaffResponseStaffDetail
import com.example.petofy.apiResponse.petlist_response_atributes
import com.example.petofy.databinding.ActivityMyStaffBinding
import com.example.petofy.getpetlist.MyPetAdapter
import com.example.petofy.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyStaffActivity : AppCompatActivity() {
    lateinit var binding: ActivityMyStaffBinding
    var isLoading = false
    var page = "1"
    var count=1
    lateinit var adapter:MyStaffAdapter
    var newData = ArrayList<MyStaffResponseStaffDetail>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMyStaffBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycleView.layoutManager=LinearLayoutManager(this)
        binding.shimmerContainer.startShimmerAnimation()
        getStaff("1")
        binding.recycleView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

                if (dy > 0) {
                    var visibleItemCount = binding.recycleView?.layoutManager?.childCount
                    var pastVisibleItem =
                        (binding.recycleView.layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()

                    var total = binding.recycleView.adapter?.itemCount
                    if (!isLoading) {

                        if (visibleItemCount!! + pastVisibleItem >= total!!) {


                            page=""
                            count=count+1
                            page=count.toString()
                            if (count<6) {
                                getStaff(page)
                            }

                        }
                    }
                }

                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }
    private fun getStaff(page: String) {
        val token = shrd.getString("valid", "null")
        RetrofitClient.staffintance.getStaffList(token, MyStaffRequest(MyStaffRequestData(page,"10",""))).enqueue(object : Callback<MyStaffResponse?> {
            override fun onResponse(
                call: Call<MyStaffResponse?>,
                response: Response<MyStaffResponse?>
            ) {
               if(response.body()!=null)
               {
                   binding.shimmerContainer.visibility=View.INVISIBLE
                   binding.shimmerContainer.stopShimmerAnimation()
                  val stafflist= response.body()?.data?.staffDetail

                   if (::adapter.isInitialized && binding.recycleView.adapter is MyStaffAdapter) {

                       newData = stafflist as ArrayList<MyStaffResponseStaffDetail>
                       (binding.recycleView.adapter as MyStaffAdapter)?.appendData(newData)
                   } else {
                       adapter = MyStaffAdapter(stafflist as ArrayList<MyStaffResponseStaffDetail>)
                       binding.recycleView.adapter = adapter

                   }

               }
            }
            override fun onFailure(call: Call<MyStaffResponse?>, t: Throwable) {
              Toast.makeText(this@MyStaffActivity,"error",Toast.LENGTH_SHORT).show()
            }
        })

    }
}