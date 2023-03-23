package com.example.petofy.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.petofy.R
import com.example.petofy.apiResponse.MyStaffResponseStaffDetail

class MyStaffAdapter(var item: ArrayList<MyStaffResponseStaffDetail>,private val listener:ActiveClicked) : RecyclerView.Adapter<MyStaffAdapter.ViewHolder>() {


   // private var filteredList: MutableList<MyStaffResponseStaffDetail> = item.toMutableList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.staff_resource_file,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return  item.size
    }

    fun setData(newList: List<MyStaffResponseStaffDetail>) {
       item.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentData=item[position]
        holder.staffname.text=currentData.firstName
        holder.staffemail.text=currentData.email
        holder.staffstudy.text=currentData.vetQualification
        holder.stafflastname.text=currentData.lastName
        holder.phonenumber.text=currentData.phoneNumber
        holder.status.setOnClickListener()
        {
          listener.itemClicked(holder.status,currentData.encryptedId)

        }
        holder.viewDetails.setOnClickListener()
        {

            listener.vieDetailsClicked(holder.viewDetails,currentData.firstName,currentData.lastName,currentData.email,currentData.vetQualification,currentData.phoneNumber)
        }

    }

    fun appendData(newData: ArrayList<MyStaffResponseStaffDetail>) {
        item=newData
        notifyDataSetChanged()

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var staffname=itemView.findViewById<TextView>(R.id.staff_first_name)
        var stafflastname=itemView.findViewById<TextView>(R.id.staff_last_name)
        var staffstudy=itemView.findViewById<TextView>(R.id.staff_study)
        var staffemail=itemView.findViewById<TextView>(R.id.staff_email)
        var phonenumber=itemView.findViewById<TextView>(R.id.phonenumber)
        var status=itemView.findViewById<TextView>(R.id.staff_status)
        var viewDetails=itemView.findViewById<TextView>(R.id.viewDetails)
    }

}

interface ActiveClicked
{
    fun itemClicked(active: TextView, encryptedId: String)
    fun vieDetailsClicked(
        viewdetails: TextView,
        firstName: String,
        lastName: String?,
        email: String,
        vetQualification: String?,
        phoneNumber: String?
    )
}