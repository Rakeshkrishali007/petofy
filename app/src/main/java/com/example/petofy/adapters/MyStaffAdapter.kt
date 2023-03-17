package com.example.petofy.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.petofy.R
import com.example.petofy.apiResponse.MyStaffResponseStaffDetail

class MyStaffAdapter(private val item: ArrayList<MyStaffResponseStaffDetail>) : RecyclerView.Adapter<MyStaffAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.staff_resource_file,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return  item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentData=item[position]
        holder.staffname.text=currentData.firstName
        holder.staffemail.text=currentData.email
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var staffname=itemView.findViewById<TextView>(R.id.staff_name)
        var staffstudy=itemView.findViewById<TextView>(R.id.staff_study)
        var staffemail=itemView.findViewById<TextView>(R.id.staff_email)
    }

}