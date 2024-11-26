package com.example.project1892.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project1892.Activity.DetailActivity
import com.example.project1892.Domain.ItemDomain
import com.example.project1892.databinding.ViewholderPopularBinding

class PopularAdapter(private val items: ArrayList<ItemDomain?>) :
    RecyclerView.Adapter<PopularAdapter.Viewholder>() {

    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        context = parent.context
        val binding = ViewholderPopularBinding.inflate(LayoutInflater.from(context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val item = items[position]

        // Set data directly using holder.binding
        holder.binding.titleTxt.text = item?.title
        holder.binding.priceTxt.text = "$" + item?.price
        holder.binding.addressTxt.text = item?.address
        holder.binding.scoreTxt.text = item?.score.toString()

        Glide.with(context!!)
            .load(item?.pic)
            .into(holder.binding.pic)

        holder.itemView.setOnClickListener {
            val adapterPosition = holder.adapterPosition
            if (adapterPosition != RecyclerView.NO_POSITION) {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("object", items[adapterPosition])
                context!!.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class Viewholder(val binding: ViewholderPopularBinding) :
        RecyclerView.ViewHolder(binding.root)
}
