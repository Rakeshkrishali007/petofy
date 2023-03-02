package com.example.petofy.fragments.bashboardfragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
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


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPetBinding.inflate(layoutInflater)
        binding.recycleView.layoutManager = LinearLayoutManager(context)


        getPetList(1)

        return binding.root
    }

    private fun getPetList(pageNumber:Int) {
        val token= shrd.getString("valid","null")
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
                    val petList=response.body()?.data?.petList
                    val adapter=MyPetAdapter(petList as ArrayList<petlist_response_atributes>)
                    binding.recycleView.adapter=adapter
                    binding.petFragmentProgressBar.visibility=View.INVISIBLE
                    if(pageNumber<= response?.body()?.data?.pagingHeader?.totalPages!!)
                    {
                        getPetList(pageNumber+1)

                    }
                }
            }

            override fun onFailure(call: Call<PetListResponse?>, t: Throwable) {
                Log.d("error", "not running")

            }
        })

    }


}