package com.example.petofy.fragments.bashboardfragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petofy.R
import com.example.petofy.activity.shrd
import com.example.petofy.apiRequest.PetListRequest
import com.example.petofy.apiRequest.petlist_request_feilds
import com.example.petofy.apiResponse.PetListResponse
import com.example.petofy.apiResponse.petlist_response_atributes
import com.example.petofy.databinding.FragmentPetBinding
import com.example.petofy.getpetlist.*
import com.example.petofy.retrofit.RetrofitClient
import com.facebook.shimmer.ShimmerFrameLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Use the [Pet_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class Pet_Fragment : Fragment(R.layout.fragment_pet_) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentPetBinding
    lateinit var adapter: MyPetAdapter
    lateinit var shimmer: ShimmerFrameLayout
    var cout = 1
    var newData = ArrayList<petlist_response_atributes>()

    var isLoading = false
    var page = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPetBinding.inflate(layoutInflater)
        binding.recycleView.layoutManager = LinearLayoutManager(context)
        binding.shimmerViewContainer.startShimmerAnimation()

        getPetList(1)
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
                            page = page + 1
                            Log.d("count", "${page}")
                            if (page < 29) {
                                binding.progressBar.visibility = View.VISIBLE
                                getPetList(page)
                            }

                        }
                    }
                }

                super.onScrolled(recyclerView, dx, dy)
            }
        })
        return binding.root
    }

    @SuppressLint("SuspiciousIndentation")
    private fun getPetList(pageNumber: Int) {

        isLoading = true;


        val token = shrd.getString("valid", "null")
        RetrofitClient.apiInterface.getPetList(
            token,
            PetListRequest(petlist_request_feilds(pageNumber, 20, ""))
        ).enqueue(object :
            Callback<PetListResponse?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<PetListResponse?>,
                response: Response<PetListResponse?>
            ) {
                if (response.body() != null) {
                    val petList = response.body()?.data?.petList

                    binding.recycleView.visibility = View.VISIBLE
                    binding.shimmerViewContainer.stopShimmerAnimation()
                    binding.shimmerViewContainer.visibility = View.INVISIBLE
                    if (::adapter.isInitialized && binding.recycleView.adapter is MyPetAdapter) {

                        newData = petList as ArrayList<petlist_response_atributes>
                        (binding.recycleView.adapter as MyPetAdapter)?.appendData(newData)
                        binding.progressBar.visibility = View.INVISIBLE
                    } else {
                        adapter = MyPetAdapter(petList as ArrayList<petlist_response_atributes>)
                        binding.recycleView.adapter = adapter
                    }
                    isLoading = false;

                }
            }
            override fun onFailure(call: Call<PetListResponse?>, t: Throwable) {
                Log.d("error", "not running")

            }
        })

    }


}