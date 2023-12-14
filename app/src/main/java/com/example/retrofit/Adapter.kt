package com.example.myapplicationtwo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.Product
import com.example.retrofit.R

class myadapter(var data:List<Product>) : RecyclerView.Adapter<myadapter.myviewholder>() {

    class myviewholder(var a:View ): RecyclerView.ViewHolder(a)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        var h = myviewholder(LayoutInflater.from(parent.context).inflate(R.layout.items ,parent,false))
        return h
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        var tv1 = holder.itemView.findViewById<TextView>(R.id.tvProductId)
        var tv2 = holder.itemView.findViewById<TextView>(R.id.tvProductTitle)
        var tv3 = holder.itemView.findViewById<TextView>(R.id.tvProductPrice)
        var tv4 = holder.itemView.findViewById<TextView>(R.id.tvProductIdLabel)
        var tv5 = holder.itemView.findViewById<TextView>(R.id.tvProductDescription)
        var tv6 = holder.itemView.findViewById<TextView>(R.id.tvProductCategory)

        tv1.text = data[position].id.toString()
        tv2.text = data[position].category.toString()
        tv3.text = data[position].description.toString()
        tv4.text = data[position].price.toString()
        tv5.text = data[position].title.toString()
        tv6.text = data[position].rating.rate.toString()

    }


    override fun getItemCount(): Int {
        return data.size
    }


}