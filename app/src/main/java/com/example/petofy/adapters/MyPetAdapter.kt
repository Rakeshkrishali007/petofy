package com.example.petofy.getpetlist

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.petofy.R
import com.example.petofy.apiResponse.petlist_response_atributes


class MyPetAdapter(
    var item: ArrayList<petlist_response_atributes>,
    private val listener: ItemClicked,
    private  val requireContext: Context,

    ) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.my_pet_item_resource_class, parent, false)
        return MyViewHolder(view)
    }

    fun appendData(newDataList: ArrayList<petlist_response_atributes>) {
        item.addAll(newDataList)
        notifyDataSetChanged()
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      var current=item[position]

        holder.dogname.text=current.petName
        holder.dogdate.text=current.dateOfBirth
        val s1:String= current.petUniqueId.subSequence(0,5) as String
        val l=current.petUniqueId.length
        val s2=current.petUniqueId.subSequence(l-3,l) as String
        holder.petNumber.text=  s1.plus(" ").plus(s2)
        holder.owner.text=current.petParentName
        //Glide.with(requireContext).load(current.petProfileImageUrl).into(holder.petImage);
        holder.viewPetDetails.setOnClickListener()
        {
            listener.ViewPetDetailsClicked()
        }
        holder.addToClinic.setOnClickListener()
        {
            listener.AddPetToClinic()
        }

    }

    override fun getItemCount(): Int {
        return item.size
    }

    fun FilterData(filterData: ArrayList<petlist_response_atributes>) {
        item = filterData
        notifyDataSetChanged()

    }
}

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dogname = itemView.findViewById<TextView>(R.id.txt_dog_name)
        val dogdate = itemView.findViewById<TextView>(R.id.txt_dog_dataOfBirth)
        val owner = itemView.findViewById<TextView>(R.id.txt_dog_owner)
        val petNumber=itemView.findViewById<TextView>(R.id.txt_petNumber)
        val viewPetDetails=itemView.findViewById<Button>(R.id.btn_viewPetDetails)
        val addToClinic = itemView.findViewById<Button>(R.id.btn_addToClinicVisit)
        val petImage = itemView.findViewById<ImageView>(R.id.img_pet_image)
    }

interface ItemClicked
{
    fun ViewPetDetailsClicked()

    fun AddPetToClinic()
}

