package com.example.petofy.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.petofy.R
import com.example.petofy.apiResponse.PetResponseUpcomingData

class UpcomingApapter(private val item: ArrayList<PetResponseUpcomingData>): RecyclerView.Adapter<UpcomingApapter.UpcomingViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingViewHolder {
      val view=LayoutInflater.from(parent.context).inflate(R.layout.upcoming_item_resouce_file,parent,false)
        return UpcomingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: UpcomingViewHolder, position: Int) {
      val currentData=item[position]
        holder.subject.text=currentData.subject
        holder.startDate.text=currentData.startDateString
        holder.endDate.text=currentData.endDateString
        holder.status.text=currentData.statusString
    }

    class UpcomingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var subject=itemView.findViewById<TextView>(R.id.txt_subject)
        var startDate=itemView.findViewById<TextView>(R.id.txt_startTime)
        var endDate=itemView.findViewById<TextView>(R.id.txt_endTime)
        var status=itemView.findViewById<TextView>(R.id.txt_status)
    }
}