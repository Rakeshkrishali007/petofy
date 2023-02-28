package com.example.petofy.getpetlist

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.petofy.MyViewHolder
import com.example.petofy.R

class MyPetAdapter(): RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): com.example.petofy.MyViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: com.example.petofy.MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)
    {
      private val dogname=itemView.findViewById<TextView>(R.id.txt_dog_name)
      private val dateOfBirth=itemView.findViewById<TextView>(R.id.txt_dog_dataOfBirth)
     private val owner=itemView.findViewById<TextView>(R.id.txt_dog_owner)

    }
}
