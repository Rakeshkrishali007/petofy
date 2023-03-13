package com.example.petofy.fragments.bashboardfragments

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petofy.R
import com.example.petofy.activity.shrd
import com.example.petofy.activity.token
import com.example.petofy.apiRequest.PetListRequest
import com.example.petofy.apiRequest.petlist_request_feilds
import com.example.petofy.apiResponse.PetListResponse
import com.example.petofy.apiResponse.petlist_response_atributes
import com.example.petofy.databinding.FragmentPetBinding
import com.example.petofy.getpetlist.*
import com.example.petofy.retrofit.RetrofitClient
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
    var page = 0;
    var isLoading = false
    var limit = 10


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPetBinding.inflate(layoutInflater)
        val layoutmanager = LinearLayoutManager(context)
        binding.recycleView.layoutManager = LinearLayoutManager(context)

        getPetList(1)
        binding.recycleView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

                var visibleItemCount = layoutmanager.childCount
                var pastVisibleItem = layoutmanager.findFirstCompletelyVisibleItemPosition()
                var total = adapter.itemCount
                if(!isLoading)
                {
                    if(visibleItemCount+pastVisibleItem>=total)
                    {
                        page++
                        getPetList(page)
                    }
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
        return binding.root
    }

    private fun getPetList(pageNumber: Int) {

       isLoading=true
        val token = shrd.getString("valid", "null")
        RetrofitClient.petlistintanse.getPetList(
            token,
            PetListRequest(petlist_request_feilds(pageNumber, 20, ""))
        ).enqueue(object :
            Callback<PetListResponse?> {
            override fun onResponse(
                call: Call<PetListResponse?>,
                response: Response<PetListResponse?>
            ) {
                if (response.body() != null) {
                    val petList = response.body()?.data?.petList


                    if (::adapter.isInitialized) {
                        adapter.notifyDataSetChanged()
                    } else {
                        adapter = MyPetAdapter(petList as ArrayList<petlist_response_atributes>)
                        binding.recycleView.adapter = adapter
                    }
                   isLoading=false
                    binding.petFragmentProgressBar.visibility = View.INVISIBLE

                }
            }

            override fun onFailure(call: Call<PetListResponse?>, t: Throwable) {
                Log.d("error", "not running")

            }
        })

    }


}