package com.example.petofy.fragments.bashboardfragments

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.app.ProgressDialog
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.petofy.*
import com.example.petofy.Classes.CheckConnection
import com.example.petofy.Classes.ConnectivityReceiver
import com.example.petofy.Classes.HomeFragmentViewModel
import com.example.petofy.Classes.ViewModelObject.viewModel
import com.example.petofy.activity.IsSearched
import com.example.petofy.activity.LogIn_Activity
import com.example.petofy.activity.MyStaffActivity
import com.example.petofy.activity.shrd
import com.example.petofy.apiResponse.UserDashBoardCountResponse
import com.example.petofy.databinding.FragmentHomeBinding
import com.example.petofy.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


public var hasData = true

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Home_Fragment constructor() : Fragment(R.layout.fragment_home_), CheckConnection {

    val connectivityReceiver = ConnectivityReceiver(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        if (isAdded) {
            requireActivity().onBackPressedDispatcher.addCallback(
                viewLifecycleOwner,
                object : OnBackPressedCallback(true) {
                    override fun handleOnBackPressed() {

                        requireActivity().finish()
                    }
                })


        }
    }


    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentHomeBinding

    var progressDialog: ProgressDialog? = null


    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View {


        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.search.setOnClickListener()
        {
            val intent = Intent(this@Home_Fragment.requireContext(), IsSearched::class.java)
            startActivity(intent)
        }

        if (viewModel == null)
            viewModel = ViewModelProvider(this)[HomeFragmentViewModel::class.java]

        if (hasData) {
            getPetCount()
        } else {
            setViewModelData()
        }


        binding.staff.setOnClickListener()
        {
            val intent = Intent(this@Home_Fragment.requireContext(), MyStaffActivity::class.java)
            startActivity(intent)
        }
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

    /* override fun onDestroy() {
         super.onDestroy()

         // Unregister the BroadcastReceiver when the activity is destroyed
         unregisterReceiver(connectivityReceiver)
     }*/
    public fun setViewModelData() {

        Log.d("yes1", "hello")
        binding.txtAppointment.text = viewModel?.onlineAppointment
        binding.txtMyPets.text = viewModel?.myPet
        binding.txtStaff.text = viewModel?.staff

    }


    override fun onResume() {
        super.onResume()

        val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        requireActivity().registerReceiver(connectivityReceiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        requireActivity().unregisterReceiver(connectivityReceiver)
    }

    private fun loadFragment(fragment: Fragment) {
        val transactionManger = activity?.supportFragmentManager
        val fragmentTransaction = transactionManger?.beginTransaction()
        fragmentTransaction?.replace(R.id.container, fragment)

        fragmentTransaction?.addToBackStack(Home_Fragment().toString())
        var count = transactionManger?.backStackEntryCount
        for (i in 0 until count!! - 1) {
            transactionManger?.popBackStack()
        }
        fragmentTransaction?.commit()
    }

    private fun getPetCount() {

        progressDialog = ProgressDialog(context)
        progressDialog!!.setTitle("Loading")
        progressDialog!!.setMessage("Please wait...")
        progressDialog!!.setCancelable(false)
        progressDialog!!.show()


        val token = shrd.getString("valid", "null")
        RetrofitClient.apiInterface.GetDashBoardCount(token).enqueue(object :
            Callback<UserDashBoardCountResponse?> {
            override fun onResponse(
                call: Call<UserDashBoardCountResponse?>,
                response: Response<UserDashBoardCountResponse?>
            ) {
                if (response.body() != null) {
                    binding.progressBar.visibility = View.INVISIBLE
                    viewModel?.myPet = response.body()?.data?.numberOfPets.toString()
                    viewModel?.onlineAppointment =
                        response.body()?.data?.numberOfAppointments.toString()
                    viewModel?.staff = response.body()?.data?.numberOfStaffs.toString()
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun isConnectedToInternet(isConnected: Boolean) {

        val view = LayoutInflater.from(this@Home_Fragment.requireContext())
            .inflate(R.layout.custom_internet_dialog_alert, null)
        var mBuilder = AlertDialog.Builder(this.requireContext())
            .setView(R.layout.custom_internet_dialog_alert)
        if (!isConnected) {
            val view = LayoutInflater.from(this@Home_Fragment.requireContext())
                .inflate(R.layout.custom_internet_dialog_alert, null)
            var mBuilder = AlertDialog.Builder(this.requireContext())
                .setView(R.layout.custom_internet_dialog_alert)
            var  mBuilderDialog = mBuilder.show()
            val tryagain=view.findViewById<Button>(R.id.btn_try_again)
            tryagain.setOnClickListener()
            {
                mBuilderDialog.dismiss()
            }

        }




    }


}