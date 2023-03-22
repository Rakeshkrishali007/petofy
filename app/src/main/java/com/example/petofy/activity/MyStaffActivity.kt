package com.example.petofy.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SearchView
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
import java.util.*
import kotlin.collections.ArrayList

class MyStaffActivity : AppCompatActivity() {
    lateinit var binding: ActivityMyStaffBinding
    var isLoading = false
    lateinit var  stafflist:ArrayList<MyStaffResponseStaffDetail>
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
        binding.addStaff.setOnClickListener()
        {
            val intent= Intent(this@MyStaffActivity,AddStaffActivity::class.java)
            startActivity(intent)
        }
        binding.search.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
               return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
              FilterName(newText)
                return true
            }

            private fun FilterName(query: String?) {
                val filterList= ArrayList<MyStaffResponseStaffDetail>()
                if(query!=null){
                    for(i in stafflist)
                    {
                        if(i.firstName=="shivani")
                        {
                            Log.d("true","yes")
                        }
                        else
                        {
                            Log.d("true","${i.firstName}")
                        }
                        if(i.firstName==query)
                        {
                            filterList.add(i)

                        }
                    }
                    if(filterList.isEmpty())
                    {
                        Toast.makeText(this@MyStaffActivity, "No data found", Toast.LENGTH_SHORT).show()

                    }
                    else
                    {
                        adapter.setData(filterList)
                    }
                }

            }
        })
        binding.recycleView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

                if (dy > 0) {
                    var visibleItemCount = binding.recycleView?.layoutManager?.childCount
                    var pastVisibleItem =
                        (binding.recycleView.layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()

                    var total = binding.recycleView.adapter?.itemCount
                    if (!isLoading) {

                        if (visibleItemCount!! + pastVisibleItem >= total!!) {

                           binding.progressBar.visibility=View.VISIBLE

                            page=""
                            count=count+1
                            page=count.toString()
                            if (count<6) {
                                getStaff(page)
                            }
                            else
                            {
                               binding.progressBar.visibility=View.INVISIBLE
                            }

                        }
                    }
                }

                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

   /* private fun FilterList(query: String?) {

          val filterList= ArrayList<MyStaffResponseStaffDetail>()
        if(query!=null)
        {

            for(i in stafflist )
            {
                Log.d("name","${i.firstName}")
                if(i.firstName.lowercase(Locale.ROOT).contains(query.toLowerCase())){
                    filterList.add(i)
                }
            }
            if(filterList.isEmpty())
            {
                Toast.makeText(this@MyStaffActivity, "No data found", Toast.LENGTH_SHORT).show()

            }
            else
            {
                adapter.setData(filterList)
            }
        }


    }*/

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
                   stafflist= response.body()?.data?.staffDetail as ArrayList<MyStaffResponseStaffDetail>


                   if (::adapter.isInitialized && binding.recycleView.adapter is MyStaffAdapter) {

                       newData = stafflist
                       (binding.recycleView.adapter as MyStaffAdapter)?.appendData(newData)
                       binding.progressBar.visibility=View.INVISIBLE
                   } else {
                       adapter = MyStaffAdapter(stafflist )
                       binding.recycleView.adapter = adapter
                       binding.progressBar.visibility=View.INVISIBLE

                   }

               }
            }
            override fun onFailure(call: Call<MyStaffResponse?>, t: Throwable) {
              Toast.makeText(this@MyStaffActivity,"error",Toast.LENGTH_SHORT).show()
            }
        })

    }
}