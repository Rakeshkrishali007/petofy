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
import com.example.petofy.fragments.bashboardfragments.MyStaffFragment

class MyStaffAdapter(
    var item: ArrayList<MyStaffResponseStaffDetail>,
    private val listener: MyStaffFragment,
    myStaffActivity: Context

) : RecyclerView.Adapter<MyStaffAdapter.ViewHolder>() {

    private val mcontext = myStaffActivity

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
        holder.phonenumber.text = currentData.phoneNumber
        Log.d("check", "${currentData.isActive},${currentData.email},${currentData.encryptedId}")
        Log.d("tag", "onBindViewHolder"+"${currentData.isActive}")

        holder.status.setOnClickListener()
        {
            Log.d("tag", "${currentData.isActive}")
            if(holder.status.text == "Active")
            {
                listener.itemClicked(false,currentData.encryptedId)
                holder.status.setTextColor(Color.parseColor("#FF0000"))
                holder.status.text = "Deactive"
                holder.status.setCompoundDrawablesWithIntrinsicBounds(
                    0, 0, R.drawable.down_arrow_red, 0
                )

            }
            else
            {
                listener.itemClicked(true,currentData.encryptedId)
                holder.status.setTextColor(Color.parseColor("#47B84B"))
                holder.status.text = "Active"
                holder.status.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.down_arrow,
                    0
                )
            }
        }


        if (currentData.isActive == true) {
            holder.status.setTextColor(Color.parseColor("#47B84B"))
            holder.status.text = "Active"
            holder.status.setCompoundDrawablesWithIntrinsicBounds(
                0, 0, R.drawable.down_arrow, 0
            )
        } else {
            holder.status.setTextColor(Color.parseColor("#FF0000"))
            holder.status.text = "Deactive"
            holder.status.setCompoundDrawablesWithIntrinsicBounds(
                0,
                0,
                R.drawable.down_arrow_red,
                0
            )
        }
        holder.viewDetails.setOnClickListener()
        {
            val intent = Intent(mcontext, ViewStaffDetails::class.java)
            intent.putExtra("Firstname", currentData.firstName)
            intent.putExtra("Lastname", currentData.lastName)
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
        var staffname = itemView.findViewById<TextView>(R.id.txt_staff_name)
        var staffstudy = itemView.findViewById<TextView>(R.id.staff_study)
        var staffemail = itemView.findViewById<TextView>(R.id.staff_email)
        var phonenumber = itemView.findViewById<TextView>(R.id.phonenumber)
        var status = itemView.findViewById<TextView>(R.id.txt_staff_status)
        var viewDetails = itemView.findViewById<TextView>(R.id.viewDetails)
    }

}

interface ActiveClicked {
    fun itemClicked(bool:Boolean, encryptedId: String)


}