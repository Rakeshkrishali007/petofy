package com.example.petofy.adapters


import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.petofy.R
import com.example.petofy.activity.ViewStaffDetails
import com.example.petofy.apiResponse.MyStaffResponseStaffDetail

class MyStaffAdapter(
    var item: ArrayList<MyStaffResponseStaffDetail>,
    private val listener: Context,
    myStaffActivity: Context

) : RecyclerView.Adapter<MyStaffAdapter.ViewHolder>() {

    private  val mcontext=myStaffActivity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.staff_resource_file, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    fun setData(newList: List<MyStaffResponseStaffDetail>) {
        item.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentData = item[position]
        holder.staffname.text = currentData.firstName
        holder.staffemail.text = currentData.email
        holder.staffstudy.text = currentData.vetQualification
        holder.stafflastname.text = currentData.lastName
        holder.phonenumber.text = currentData.phoneNumber
        Log.d("check","${currentData.isActive},${currentData.email},${currentData.encryptedId}")
        holder.status.setOnClickListener()
        {
            listener.itemClicked(holder.status, currentData.encryptedId)
        }
        if(currentData.isActive==true)
        {
            holder.status.setTextColor(Color.parseColor("#47B84B"))
            holder.status.text = "Active"
            holder.status.setCompoundDrawablesWithIntrinsicBounds(
                0, 0, R.drawable.down_arrow, 0
            )
        }
        else
        {
            holder.status.setTextColor(Color.parseColor("#FF0000"))
            holder.status.text = "Deactive"
            holder.status.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.down_arrow_red, 0)
        }
        holder.viewDetails.setOnClickListener()
        {
            val intent = Intent(mcontext, ViewStaffDetails::class.java)
            intent.putExtra("Firstname", currentData.firstName)
            intent.putExtra("Lastname",currentData.lastName)
            intent.putExtra("Email", currentData.email)
            intent.putExtra("Study", currentData.vetQualification)
            intent.putExtra("PhoneNumber", currentData.phoneNumber)

           mcontext.startActivity(intent);
        }

    }

    fun FilterData(newData: ArrayList<MyStaffResponseStaffDetail>) {
        item = newData
        notifyDataSetChanged()
    }

    fun appendData(newData: ArrayList<MyStaffResponseStaffDetail>) {
        item.addAll(newData)
        notifyDataSetChanged()

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var staffname = itemView.findViewById<TextView>(R.id.staff_first_name)
        var stafflastname = itemView.findViewById<TextView>(R.id.staff_last_name)
        var staffstudy = itemView.findViewById<TextView>(R.id.staff_study)
        var staffemail = itemView.findViewById<TextView>(R.id.staff_email)
        var phonenumber = itemView.findViewById<TextView>(R.id.phonenumber)
        var status = itemView.findViewById<TextView>(R.id.staff_status)
        var viewDetails = itemView.findViewById<TextView>(R.id.viewDetails)
    }

}

interface ActiveClicked {
    fun itemClicked(active: TextView, encryptedId: String)


}