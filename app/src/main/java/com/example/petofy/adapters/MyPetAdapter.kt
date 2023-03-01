package com.example.petofy.getpetlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.petofy.R
import com.example.petofy.apiResponse.petlist_response_atributes

class MyPetAdapter(private val item: ArrayList<petlist_response_atributes>) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.my_pet_item_resource_class, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      var current=item[position]

        holder.dogname.text=current.petName
        holder.dogdate.text=current.dateOfBirth
        holder.petNumber.text=current.petUniqueId
        holder.owner.text=current.petParentName
    }

    override fun getItemCount(): Int {
        return item.size
    }
}

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dogname = itemView.findViewById<TextView>(R.id.txt_dog_name)
        val dogdate = itemView.findViewById<TextView>(R.id.txt_dog_dataOfBirth)
        val owner = itemView.findViewById<TextView>(R.id.txt_dog_owner)
        val petNumber=itemView.findViewById<TextView>(R.id.txt_petNumber)
    }

