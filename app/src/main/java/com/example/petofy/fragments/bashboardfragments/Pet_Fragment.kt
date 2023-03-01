package com.example.petofy.fragments.bashboardfragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petofy.ARG_PARAM1
import com.example.petofy.ARG_PARAM2
import com.example.petofy.R
import com.example.petofy.databinding.FragmentPetBinding
import com.example.petofy.getpetlist.*
import com.example.petofy.token
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
       binding= FragmentPetBinding.inflate(layoutInflater)
        binding.recycleView.layoutManager= LinearLayoutManager(context)
        PetListClient.petlistintanse.getPetList(token, PetListRequest(Data(1, 1, ""))).enqueue(object :
            Callback<PetListResponse?> {
             override fun onResponse(
                 call: Call<PetListResponse?>,
                 response: Response<PetListResponse?>
             ) {
                 if(response.body()!=null)
                 {

                      val petList= PetListResponse(DataX(List<Pet>)).data.petList
                     val adapter= MyPetAdapter(petList.data.petList as ArrayList<Pet>)
                     binding.recycleView.adapter=adapter
                 }
             }

             override fun onFailure(call: Call<PetListResponse?>, t: Throwable) {
                 Log.d("error", "not running")

             }
         })

        return binding.root
    }


}