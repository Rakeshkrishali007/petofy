package com.example.petofy

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petofy.databinding.FragmentPetBinding
import com.example.petofy.getpetlist.*
import com.example.petofy.getpetlist.Data
import com.example.petofy.getpetlist.DataX
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Pet_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Pet_Fragment : Fragment(R.layout.fragment_pet_) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var  binding: FragmentPetBinding

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
    ): View? {
       binding=FragmentPetBinding.inflate(layoutInflater)
        binding.recycleView.layoutManager=LinearLayoutManager(context)
        PetListClient.petlistintanse.getPetList(token,PetListRequest(Data(1,1,""))).enqueue(object : Callback<PetListResponse?> {
             override fun onResponse(
                 call: Call<PetListResponse?>,
                 response: Response<PetListResponse?>
             ) {
                 if(response.body()!=null)
                 {
                     Log.d("response", "onResponse: ${response.body()}")
                     val petList=PetListResponse().data.petList
                     //val PetList= petList.data.petList

                     val adapter=MyPetAdapter(petList.data.petList as ArrayList<Pet>)
                     binding.recycleView.adapter=adapter
                 }
             }

             override fun onFailure(call: Call<PetListResponse?>, t: Throwable) {
               Log.d("errorfr","not running")

             }
         })

        return binding.root
    }


}