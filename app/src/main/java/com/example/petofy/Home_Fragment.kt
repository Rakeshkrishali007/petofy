package com.example.petofy

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.petofy.databinding.ActivityDashBoardBinding
import com.example.petofy.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [Home_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home_Fragment : Fragment(R.layout.fragment_home_) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding:FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View{

        binding= FragmentHomeBinding.inflate(inflater,container,false)

        UserDashBoardCountClient.dashBoardCountInstance.GetDashBoardCount(token).enqueue(object : Callback<UserDashBoardCountResponse?> {
            override fun onResponse(
                call: Call<UserDashBoardCountResponse?>,
                response: Response<UserDashBoardCountResponse?>
            ) {

                 if(response.body()!=null)
                 {
                     binding.txtMyPets.text=response.body()?.data?.numberOfPets.toString()
                     binding.txtAppointment.text= response.body()?.data?.numberOfAppointments.toString()
                     binding.txtStaff.text= response.body()?.data?.numberOfStaffs.toString()

                 }
            }

            override fun onFailure(call: Call<UserDashBoardCountResponse?>, t: Throwable) {
                Log.d("error", "onResponse: not runnning")
            }
        })
        return binding.root//inflater.inflate(R.layout.fragment_home_, container, false)
    }


}