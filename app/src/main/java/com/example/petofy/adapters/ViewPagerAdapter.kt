package com.example.petofy.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.petofy.R
import org.w3c.dom.Text


class ViewPagerAdapter(val images: List<Int>,val text:List<String>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentImage = images[position]
        val currentText=text[position]
        holder.img.setImageResource(currentImage)
        holder.docu.text=currentText

    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
val img=itemView.findViewById<ImageView>(R.id.img)
    val docu=itemView.findViewById<TextView>(R.id.txt_description)
}