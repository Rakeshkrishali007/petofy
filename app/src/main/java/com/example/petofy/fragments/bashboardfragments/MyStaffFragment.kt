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
import com.example.petofy.activity.bool
import com.example.petofy.activity.shrd
import com.example.petofy.adapters.ActiveClicked
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
val api = false

class MyStaffFragment : Fragment(R.layout.fragment_my_staff), ActiveClicked {
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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyStaffBinding.inflate(layoutInflater)
        init()

        binding.shimeercontainer.startShimmerAnimation()


        searchBarFilter()

        binding.addStaff.setOnClickListener()
        {
            loadFragment(AddStafFragment())
        }

        if (!api) 4
        getStaffList()

        return binding.root
    }

    private fun loadFragment(fragment: Fragment) {
        val transactionManger = activity?.supportFragmentManager
        val fragmentTransaction = transactionManger?.beginTransaction()
        fragmentTransaction?.replace(R.id.myStaffContainer, fragment)
        //   fragmentTransaction?.addToBackStack("my_fragment")
        var count = transactionManger?.backStackEntryCount
        /* for(i in 0 until count-1)
         {
             transactionManger.popBackStack()
         }*/
        fragmentTransaction?.commit()


    }

    private fun init() {
        binding = FragmentMyStaffBinding.inflate(layoutInflater)
        binding.recycleView.layoutManager =
            LinearLayoutManager(this@MyStaffFragment.requireContext())
    }

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


    private fun openAddStaffScreen() {
        binding.addStaff.setOnClickListener() {
            /*  val intent = Intent(this@MyStaffActivity, AddStafFragment::class.java)
              startActivity(intent)*/
        }
    }

    private fun MyStaffFragment.onBackPress() {
        /*  binding.backPressed.setOnClickListener() {
              onBackPressed()
          }*/
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

                            MyStaffAdapter(
                                stafflist, this@MyStaffFragment,
                                requireActivity()

                            )
                        binding.recycleView.adapter = adapter
                        binding.progressBar.visibility = View.INVISIBLE

                    }

                }
            }

            override fun onFailure(call: Call<MyStaffResponse?>, t: Throwable) {
                if (isAdded) {
                    Toast.makeText(
                        this@MyStaffFragment.requireContext(),
                        "error",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }


        })

    }

    private fun changeStatus(status: Boolean, encryptedId: String, active: TextView) {
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
                    RefectorStafStatus(active)
                    Toast.makeText(
                        this@MyStaffFragment.requireContext(),
                        "Status changed successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                    adapter.setText(true)
                }
            }

            override fun onFailure(call: Call<ChangeStaffStatusResponse?>, t: Throwable) {


                Toast.makeText(this@MyStaffFragment.requireContext(), "error", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    fun RefectorStafStatus(active: TextView) {
        if (active.text.toString() == "Active") {

            active.setTextColor(Color.parseColor("#FF0000"))
            active.text = "Deactive"
            active.setCompoundDrawablesWithIntrinsicBounds(
                0, 0, R.drawable.down_arrow_red, 0
            )

        } else {
            active.setTextColor(Color.parseColor("#47B84B"))
            active.text = "Active"
            active.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.down_arrow, 0)
        }
    }


    override fun itemClicked(active: TextView, encryptedId: String) {
        changeStatus(false, encryptedId, active)
    }

}