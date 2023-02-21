package com.example.petofy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class ViewPagerAdapter(val images: List<Int>) : RecyclerView.Adapter<MyViewHolder>() {
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
        holder.itemView.img.setImageResource(currentImage)

    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}