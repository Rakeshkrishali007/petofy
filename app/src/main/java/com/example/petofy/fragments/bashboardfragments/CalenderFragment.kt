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
import com.example.petofy.adapters.PendingRequestAdapter
import com.example.petofy.adapters.UpcomingApapter
import com.example.petofy.apiRequest.PetPendingRequest
import com.example.petofy.apiRequest.PetPendingRequestData
import com.example.petofy.apiRequest.PetRequestUpcominig
import com.example.petofy.apiRequest.PetRequestUpcominigData
import com.example.petofy.apiResponse.PetPendingResponse
import com.example.petofy.apiResponse.PetPendingResponseData
import com.example.petofy.apiResponse.PetResponseUpcoming
import com.example.petofy.apiResponse.PetResponseUpcomingData
import com.example.petofy.databinding.FragmentCalenderBinding
import com.example.petofy.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Use the [CalenderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CalenderFragment : Fragment(R.layout.fragment_calender_) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentCalenderBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCalenderBinding.inflate(layoutInflater)
        binding.recycleView.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.recycleViewUpcoming.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        getUpcoming()
        getPendingRequest()


        return binding.root
    }

    private fun getUpcoming() {
        val token= shrd.getString("valid","null")
        RetrofitClient.petupcomingintance.getUpcomingRequest(token, PetRequestUpcominig(
            PetRequestUpcominigData("20/03/2023")
        )).enqueue(object : Callback<PetResponseUpcoming?> {
            override fun onResponse(
                call: Call<PetResponseUpcoming?>,
                response: Response<PetResponseUpcoming?>
            ) {
               if(response.body()!=null)

               {
                  val list=response.body()?.data
                   val adapter=UpcomingApapter(list as ArrayList<PetResponseUpcomingData>)
                   binding.recycleViewUpcoming.adapter=adapter
                   binding.progressBar1.visibility=View.INVISIBLE
               }
            }

            override fun onFailure(call: Call<PetResponseUpcoming?>, t: Throwable) {

                Log.d("petupcomingError","$t")
            }
        })
    }

    private fun getPendingRequest() {
        val token= shrd.getString("valid","null")
      RetrofitClient.petpendingintance.getPendinRequest( token, PetPendingRequest(
          PetPendingRequestData("06/03/2023","06/04/2023")
      )).enqueue(object : Callback<PetPendingResponse?> {
          override fun onResponse(
              call: Call<PetPendingResponse?>,
              response: Response<PetPendingResponse?>
          ) {
              if(response.body()!=null)
              {
                  val list=response.body()?.info
                  val adapter=PendingRequestAdapter(list as ArrayList<PetPendingResponseData>)
                  binding.recycleView.adapter=adapter
                binding.progressBar2.visibility=View.INVISIBLE


              }
          }

          override fun onFailure(call: Call<PetPendingResponse?>, t: Throwable) {
              Log.d("petPendingError","${t}")
          }
      })
    }

}