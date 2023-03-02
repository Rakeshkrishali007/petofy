package com.example.petofy.fragments.bashboardfragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.petofy.*
import com.example.petofy.activity.shrd
import com.example.petofy.activity.token
import com.example.petofy.apiResponse.UserDashBoardCountResponse
import com.example.petofy.databinding.FragmentHomeBinding
import com.example.petofy.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Use the [Home_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home_Fragment : Fragment(R.layout.fragment_home_) {

    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {

        binding= FragmentHomeBinding.inflate(layoutInflater)
        binding.MyPet.setOnClickListener()
        {
            loadFragment(Pet_Fragment())

        }
        getPetCount()
        val pet=requireActivity().findViewById<TextView>(R.id.txt_myPets)


        return binding.root
    }

    private fun loadFragment(fragment: Fragment) {
        val transactionManger =activity?.supportFragmentManager
        val fragmentTransaction=transactionManger?.beginTransaction()
        fragmentTransaction?.replace(R.id.container,fragment)
        fragmentTransaction?.commit()
    }

    private fun getPetCount() {

        val token= shrd.getString("valid","null")
        RetrofitClient.dashBoardCountInstance.GetDashBoardCount(token).enqueue(object :
            Callback<UserDashBoardCountResponse?> {
            override fun onResponse(
                call: Call<UserDashBoardCountResponse?>,
                response: Response<UserDashBoardCountResponse?>
            ) {

                if(response.body()!=null)
                {    binding.homeFragment.visibility=View.INVISIBLE
                    Log.d("res", "onResponse: ${response.body()?.data?.numberOfPets}")
                    binding.txtMyPets.text=response.body()?.data?.numberOfPets.toString()

                    binding.txtAppointment.text= response.body()?.data?.numberOfAppointments.toString()
                    binding.txtStaff.text= response.body()?.data?.numberOfStaffs.toString()

                }
            }

            override fun onFailure(call: Call<UserDashBoardCountResponse?>, t: Throwable) {
                Log.d("error", "onResponse: not runnning")
            }
        })
    }


}