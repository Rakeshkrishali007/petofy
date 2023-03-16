package com.example.petofy.fragments.bashboardfragments

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.example.petofy.*
import com.example.petofy.Classes.HomeFragmentViewModel
import com.example.petofy.activity.shrd
import com.example.petofy.apiResponse.UserDashBoardCountResponse
import com.example.petofy.databinding.FragmentHomeBinding
import com.example.petofy.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


public var hasData = true

class Home_Fragment : Fragment(R.layout.fragment_home_) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Log.d("viewmodel","${viewModel.staff}")
        if(isAdded)
        {
            requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {

                    requireActivity().finish()
                }
            })


        }
    }
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentHomeBinding
    lateinit var viewModel: HomeFragmentViewModel
    var progressDialog: ProgressDialog? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?



    ): View {

        Log.d("tag", "come back")
        binding = FragmentHomeBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this)[HomeFragmentViewModel::class.java]
        if (hasData)
        {

            getPetCount()
        }
        else
        {
          //  viewModel.showData()
        }
        setViewModelData()
        binding.appointment.setOnClickListener()
        {

            hasData = false
            loadFragment(CalenderFragment())
        }
        binding.MyPet.setOnClickListener()
        {
            hasData = false
            loadFragment(Pet_Fragment())
        }
        val pet = requireActivity().findViewById<TextView>(R.id.txt_myPets)
        return binding.root
    }
   public fun setViewModelData() {

        binding.txtAppointment.text = viewModel.onlineAppointment
        binding.txtMyPets.text = viewModel.myPet
        binding.txtStaff.text = viewModel.staff
    }
    private fun loadFragment(fragment: Fragment) {
        val transactionManger = activity?.supportFragmentManager
        val fragmentTransaction = transactionManger?.beginTransaction()
        fragmentTransaction?.replace(R.id.container, fragment)
        fragmentTransaction?.addToBackStack(null)
        fragmentTransaction?.commit()
    }

    private fun getPetCount() {

        progressDialog = ProgressDialog(context)
        progressDialog!!.setTitle("Loading")
        progressDialog!!.setMessage("Please wait...")
        progressDialog!!.setCancelable(false)
        progressDialog!!.show()


        val token = shrd.getString("valid", "null")
        RetrofitClient.dashBoardCountInstance.GetDashBoardCount(token).enqueue(object :
            Callback<UserDashBoardCountResponse?> {
            override fun onResponse(
                call: Call<UserDashBoardCountResponse?>,
                response: Response<UserDashBoardCountResponse?>
            ) {
                if (response.body() != null) {
                    binding.progressBar.visibility = View.INVISIBLE
                    viewModel.myPet = response.body()?.data?.numberOfPets.toString()
                    viewModel.onlineAppointment =
                        response.body()?.data?.numberOfAppointments.toString()
                    viewModel.staff = response.body()?.data?.numberOfStaffs.toString()
                    viewModel.showData2()
                    binding.txtMyPets.text = response.body()?.data?.numberOfPets.toString()
                    binding.txtAppointment.text =
                        response.body()?.data?.numberOfAppointments.toString()
                    binding.txtStaff.text = response.body()?.data?.numberOfStaffs.toString()

                }
                progressDialog?.dismiss()
            }

            override fun onFailure(call: Call<UserDashBoardCountResponse?>, t: Throwable) {
                Log.d("error", "onResponse: not runnning")
            }
        })
    }


}