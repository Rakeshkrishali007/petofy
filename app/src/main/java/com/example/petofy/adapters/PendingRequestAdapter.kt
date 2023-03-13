package com.example.petofy.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.petofy.R
import com.example.petofy.apiResponse.PetPendingResponseData

class PendingRequestAdapter(private val item: ArrayList<PetPendingResponseData>):RecyclerView.Adapter<PendingRequestAdapter.PendingViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PendingViewHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.pending_item_resource_file,parent,false)
        return  PendingViewHolder(view)
    }

    override fun getItemCount(): Int {
       return  item.size
    }

    override fun onBindViewHolder(holder: PendingViewHolder, position: Int) {
       val currentData=item[position]
        holder.startTime.text=currentData.startDateString
        holder.endTime.text=currentData.endDateString
        holder.test_name.text=currentData.subject

    }


    class PendingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var startTime=itemView.findViewById<TextView>(R.id.txt_startTime)
        var endTime=itemView.findViewById<TextView>(R.id.txt_endTime)
        var test_name=itemView.findViewById<TextView>(R.id.txt_testName)
    }

}