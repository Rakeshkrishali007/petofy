package com.example.petofy.fragments.bashboardfragments

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petofy.R
import com.example.petofy.activity.MyStaffActivity
import com.example.petofy.activity.shrd
import com.example.petofy.adapters.MyStaffAdapter
import com.example.petofy.apiRequest.ChangeStaffStatusData
import com.example.petofy.apiRequest.ChangedStaffStatusRequest
import com.example.petofy.apiRequest.MyStaffRequest
import com.example.petofy.apiRequest.MyStaffRequestData
import com.example.petofy.apiResponse.ChangeStaffStatusResponse
import com.example.petofy.apiResponse.MyStaffResponse
import com.example.petofy.apiResponse.MyStaffResponseStaffDetail
import com.example.petofy.databinding.FragmentMyStaffBinding
import com.example.petofy.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList


var status = false
class MyStaffFragment : Fragment(R.layout.fragment_my_staff) {
    lateinit var binding: FragmentMyStaffBinding
    var isLoading = false
    lateinit var stafflist: ArrayList<MyStaffResponseStaffDetail>
    var page = "1"
    var count = 1
    lateinit var adapter: MyStaffAdapter
    var newData = ArrayList<MyStaffResponseStaffDetail>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMyStaffBinding.inflate(layoutInflater)
        //init()

        binding.shimeercontainer.startShimmerAnimation()


        searchBarFilter()

        clickEvents()

        getStaffList()

        return binding.root
    }

  /*  private fun init() {
        binding = FragmentMyStaffBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycleView.layoutManager = LinearLayoutManager(this)
    }*/

    private fun getStaffList() {
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

                            binding.progressBar.visibility = View.VISIBLE

                            page = ""
                            count = count + 1
                            page = count.toString()
                            Log.d("count", "${count},${page}")
                            if (count < 6) {
                                getStaff(page)
                            } else {
                                binding.progressBar.visibility = View.INVISIBLE
                            }

                        }
                    }
                }

                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    private fun MyStaffFragment.clickEvents() {
        activity?.onBackPressed()
        openAddStaffScreen()
    }

    private fun openAddStaffScreen() {
        binding.addStaff.setOnClickListener() {
            /*  val intent = Intent(this@MyStaffActivity, AddStafFragment::class.java)
              startActivity(intent)*/
        }
    }

    private fun MyStaffActivity.onBackPress() {
        binding.backPressed.setOnClickListener() {
            onBackPressed()
        }
    }

    private fun searchBarFilter() {
        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filterData = ArrayList<MyStaffResponseStaffDetail>()
                for (item in stafflist) {
                    if (item.firstName.toLowerCase(Locale.ROOT).contains(newText.toString())) {
                        filterData.add(item)
                    }
                }
                adapter.FilterData(filterData)
                return true
            }
        })
    }

    private fun getStaff(page: String) {
        val token = shrd.getString("valid", "null")
        RetrofitClient.apiInterface.getStaffList(
            token, MyStaffRequest(MyStaffRequestData(page, "10", ""))
        ).enqueue(object : Callback<MyStaffResponse?> {
            override fun onResponse(
                call: Call<MyStaffResponse?>, response: Response<MyStaffResponse?>
            ) {

                if (response.body() != null) {
                    binding.shimeercontainer.visibility = View.INVISIBLE
                    binding.shimeercontainer.stopShimmerAnimation()

                    stafflist =
                        response.body()?.data?.staffDetail as ArrayList<MyStaffResponseStaffDetail>



                    if (::adapter.isInitialized && binding.recycleView.adapter is MyStaffAdapter) {

                        newData = stafflist
                        (binding.recycleView.adapter as MyStaffAdapter)?.appendData(newData)
                        binding.progressBar.visibility = View.INVISIBLE
                    } else {
                        adapter =
                            MyStaffAdapter(stafflist, this@MyStaffFragment.requireContext(), this@MyStaffFragment.requireContext())
                        binding.recycleView.adapter = adapter
                        binding.progressBar.visibility = View.INVISIBLE

                    }

                }
            }

            override fun onFailure(call: Call<MyStaffResponse?>, t: Throwable) {
                Toast.makeText(this@MyStaffFragment.requireContext(), "error", Toast.LENGTH_SHORT).show()
            }


        })

    }

    private fun changeStatus(status: Boolean, encryptedId: String) {
        val token = shrd.getString("valid", "null")
        RetrofitClient.apiInterface.changeStaffStatus(
            token, ChangedStaffStatusRequest(
                ChangeStaffStatusData(encryptedId, status)
            )
        ).enqueue(object : Callback<ChangeStaffStatusResponse?> {
            override fun onResponse(
                call: Call<ChangeStaffStatusResponse?>,
                response: Response<ChangeStaffStatusResponse?>
            ) {
                if (response.body() != null) {
                    Log.d("stateres", "${response!!.body()?.data?.isActive},${encryptedId}")
                    Toast.makeText(
                        this@MyStaffFragment.requireContext(), "Status changed successfully", Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<ChangeStaffStatusResponse?>, t: Throwable) {
                Toast.makeText(this@MyStaffFragment.requireContext(), "error", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun itemClicked(active: TextView, encryptedId: String) {
        if (active.text.toString() == "Active") {
            Log.d("id", "${encryptedId}")
            active.setTextColor(Color.parseColor("#FF0000"))
            active.text = "Deactive"
            active.setCompoundDrawablesWithIntrinsicBounds(
                0, 0, R.drawable.down_arrow_red, 0
            )
            changeStatus(false, encryptedId)
        } else {
            active.setTextColor(Color.parseColor("#47B84B"))
            active.text = "Active"
            active.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.down_arrow, 0)
            changeStatus(true, encryptedId)
        }

    }

}