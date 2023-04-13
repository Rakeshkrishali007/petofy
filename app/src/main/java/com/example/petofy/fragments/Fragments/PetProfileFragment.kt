package com.example.petofy.fragments.Fragments

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.petofy.R
import com.example.petofy.activity.shrd
import com.example.petofy.apiRequest.PetBreedRequestModel
import com.example.petofy.apiRequest.PetBreedRequestModelData
import com.example.petofy.apiRequest.PetColorRequestModel
import com.example.petofy.apiRequest.PetColorRequestModelData
import com.example.petofy.apiResponse.*
import com.example.petofy.databinding.FragmentPetProfileBinding
import com.example.petofy.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList


class PetProfileFragment : Fragment(R.layout.fragment_pet_profile) {

    lateinit var binding: FragmentPetProfileBinding
    val token = shrd.getString("valid", "null")
    var petCategoryId: Int = 0
    lateinit var categotyList: ArrayList<PetCategotyResponseModelData>
    lateinit var petBreedList:ArrayList<DatPetBreedResponseModelData>
    lateinit var petColorList:ArrayList<PetColorResponseModelData>
    lateinit var status: ArrayList<String>
    lateinit var  petBreddDropdownArray:ArrayList<String>
    lateinit var petColorDropdownArray:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPetProfileBinding.inflate(layoutInflater)


        binding.progressBar.visibility = View.VISIBLE
        getPetCategoty()

        OnBackPressed()

        binding.petCategotyDropdown.setOnItemClickListener(AdapterView.OnItemClickListener
        { parent: AdapterView<*>?, view: View?, position: Int, id: Long ->

            binding.progressBar.visibility = View.VISIBLE
            if (binding.petCategotyDropdown.text.toString() == "Other") {

                binding.constraint2.visibility = View.VISIBLE
            }

            if(binding.petCategotyDropdown.text.toString() != null &&binding.petCategotyDropdown.text.toString() != "Other")
            {
                binding.constraint3.visibility = View.VISIBLE
            }





                for(i in categotyList)
                {
                   if( binding.petCategotyDropdown.text.toString() == i.petType1.toString())
                   {
                       getPetColor(i.id)
                       getPetBreed(i.id)
                       getPetSize(i.id)

                   }
                }
            //GettingPetUniqueId
            getPetUniqueId()


        })

        IsCheckBoxChecked()

        DropDown()
        DatePicker()

        //Adding Pet
        binding.btnAddPet.setOnClickListener()
        {
            AddPet()
        }
        return binding.root
    }

    private fun getPetSize(id: Int) {
        RetrofitClient.apiInterface.getPetSize(token, PetColorRequestModel(PetColorRequestModelData(false, id))).enqueue(object : Callback<PetSizeIdResponseModel?> {
            override fun onResponse(
                call: Call<PetSizeIdResponseModel?>,
                response: Response<PetSizeIdResponseModel?>
            ) {
               if(response.body() != null)
               {
                   Log.d("res","success, ${response.body()!!.data}")
               }
            }

            override fun onFailure(call: Call<PetSizeIdResponseModel?>, t: Throwable) {
                Log.d("res","error")
            }
        })
    }

    private fun getPetColor(id: Int) {
       RetrofitClient.apiInterface.getPeColor(token, PetColorRequestModel(PetColorRequestModelData(false, id))).enqueue(object : Callback<PetColorResponseModel?> {
           override fun onResponse(
               call: Call<PetColorResponseModel?>,
               response: Response<PetColorResponseModel?>
           ) {
               if(response.body()!= null)
               {
                   binding.progressBar.visibility = View.INVISIBLE
                  petColorList = response.body()!!.data as ArrayList<PetColorResponseModelData>
                   petColorDropdownArray = ArrayList()
                   for(i in petColorList)
                   {
                       petColorDropdownArray.add(i.color)
                   }


                   val petColorAdapter =
                       ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item,petColorDropdownArray)
                   binding.petColorDropdown.setAdapter(petColorAdapter)



               }
           }

           override fun onFailure(call: Call<PetColorResponseModel?>, t: Throwable) {
               Toast.makeText(this@PetProfileFragment.requireContext(), "something went wrong", Toast.LENGTH_SHORT).show()
           }
       })
    }

    private fun getPetBreed(id: Int) {
        RetrofitClient.apiInterface.getPetBreed(token, PetBreedRequestModel(PetBreedRequestModelData(
            false,id))).enqueue(object : Callback<PetBreedResponseModel?> {
            override fun onResponse(
                call: Call<PetBreedResponseModel?>,
                response: Response<PetBreedResponseModel?>
            ) {
               if(response.body() != null)
               {
                   binding.progressBar.visibility = View.INVISIBLE
                  petBreedList = response.body()!!.data as ArrayList<DatPetBreedResponseModelData>
                   petBreddDropdownArray = ArrayList()
                   for(i in petBreedList)
                   {
                       petBreddDropdownArray.add(i.breed)
                   }

                   val petBreedAdapter =
                       ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, petBreddDropdownArray)
                   binding.petBreedDropdown.setAdapter(petBreedAdapter)



               }

            }

            override fun onFailure(call: Call<PetBreedResponseModel?>, t: Throwable) {
                Toast.makeText(this@PetProfileFragment.requireContext(), "something went wrong", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun getPetUniqueId() {
        RetrofitClient.apiInterface.getPetGeneratedUniqueId(token)
            .enqueue(object : Callback<PetGeneratedUniqueIdResponseModel?> {
                override fun onResponse(
                    call: Call<PetGeneratedUniqueIdResponseModel?>,
                    response: Response<PetGeneratedUniqueIdResponseModel?>
                ) {
                    if (response.body() != null) {
                        binding.progressBar.visibility = View.INVISIBLE
                    }

                }

                override fun onFailure(
                    call: Call<PetGeneratedUniqueIdResponseModel?>,
                    t: Throwable
                ) {
                    Toast.makeText(
                        this@PetProfileFragment.requireContext(),
                        "something went wrong",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
    }

    private fun getPetCategoty() {

        RetrofitClient.apiInterface.getPetCategoty(token)
            .enqueue(object : Callback<PetCategotyResponseModel?> {
                override fun onResponse(
                    call: Call<PetCategotyResponseModel?>,
                    response: Response<PetCategotyResponseModel?>
                ) {
                    if (response.body() != null) {
                        binding.progressBar.visibility = View.INVISIBLE
                        status = ArrayList()
                        categotyList =
                            response.body()!!.data as ArrayList<PetCategotyResponseModelData>
                        for (i in categotyList) {
                            status.add(i.petType1)
                        }

                        val adapter =
                            ArrayAdapter(
                                requireContext(),
                                android.R.layout.simple_spinner_dropdown_item,
                                status
                            )
                        binding.petCategotyDropdown.setAdapter(adapter)


                    }
                }

                override fun onFailure(call: Call<PetCategotyResponseModel?>, t: Throwable) {
                    Toast.makeText(
                        this@PetProfileFragment.requireContext(),
                        "something went wrong",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            })
    }

    private fun AddPet() {

        val address = binding.parentAddress.text.toString()
        val contact = binding.parentAlternameNumber.text.toString()
        val createDate = "Wednesday,01July202004:15:41AM"
        val dateOfDirth = binding.datePicker.text.toString()
        val description = null
        val fifthServiceImageUrl = ""
        val firstServiceImageUrl = ""
        val fourthServiceImageUrl = ""
        val microchipNumber = "1221"
        val petAgeId = 1.0
        val petBreedId = 1.0
        val petCategoryId = 1
        val petColorId = 3.0
        val petName = binding.petName.text.toString()
        val petParentName = binding.petParentName.text.toString()
        val petProfileImageUrl = ""
        val petSexId = 1.0
        val petSizeId = 2.0
        val petUniqueId = 1
        val secondServiceImageUrl = ""
        val thirdServiceImageUrl = ""


        // RetrofitClient.apiInterface.addPet(token, AddPetReqestModel(AddPetRequestModelData()))
        Toast.makeText(this@PetProfileFragment.requireContext(), "work in Progress", Toast.LENGTH_SHORT).show()
    }

    private fun DropDown() {


        val status2 = arrayOf("Day", "Week", "Month", "Year")
        val status3 = arrayOf(
            "bird",
            "Dutch Shepherd",
            "INDIAN RABBIT",
            "New Zealand White Rabbit",
            "Parakeet",
            "Syrian Hamster",
            "Other"
        )

        if (binding.petCategotyDropdown.text.toString() == "Other") {
            binding.constraint2.visibility = View.VISIBLE
        } else {
            binding.constraint2.visibility = View.GONE
        }
        val petColorAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, status2)
        val petDateAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, status2)




        binding.AutoCompleteTextview2.setAdapter(petDateAdapter)

    }

    private fun IsCheckBoxChecked() {
        binding.checkbox.setOnClickListener()
        {
            if (binding.checkbox.isChecked) {
                binding.txtCalender.visibility = View.INVISIBLE
                binding.txtDayAge.visibility = View.VISIBLE
            } else {
                binding.txtDayAge.visibility = View.INVISIBLE
                binding.txtCalender.visibility = View.VISIBLE
            }
        }
    }

    private fun DatePicker() {
        binding.datePicker.setOnClickListener()
        {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            var month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)


            val dpd = DatePickerDialog(
                this@PetProfileFragment.requireContext(),
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                    Log.d("date", "$dayOfMonth , $monthOfYear , $year")
                    var mutablemonth = monthOfYear + 1
                    var date = "$dayOfMonth/$mutablemonth/$year"
                    setDate(date)
                },
                year,
                month,
                day
            )

            dpd.getDatePicker().setMaxDate(System.currentTimeMillis());
            dpd.show()
        }
    }

    private fun OnBackPressed() {
        binding.backPressed.setOnClickListener()
        {
            activity?.onBackPressed()
        }
    }

    private fun setDate(date: String) {
        binding.datePicker.setText(date)

    }

}