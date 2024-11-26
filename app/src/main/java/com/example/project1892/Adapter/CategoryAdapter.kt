package com.example.project1892.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project1892.Domain.Category
import com.example.project1892.R
import com.example.project1892.databinding.ViewholderCategoryBinding

class CategoryAdapter(private val items: List<Category?>) :
    RecyclerView.Adapter<CategoryAdapter.Viewholder>() {
    private var selectedPosition = -1
    private var lastSelectedPosition = -1
    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ViewholderCategoryBinding.inflate(inflater, parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val item = items[position]

        holder.binding.title.text = item?.name
        Glide.with(holder.itemView.context)
            .load(item?.imagePath)
            .into(holder.binding.pic)

        // Set up click listener
        holder.binding.root.setOnClickListener {
            val adapterPosition = holder.adapterPosition
            if (adapterPosition != RecyclerView.NO_POSITION) {
                lastSelectedPosition = selectedPosition
                selectedPosition = adapterPosition
                notifyItemChanged(lastSelectedPosition)
                notifyItemChanged(selectedPosition)
            }
        }

        holder.binding.title.setTextColor(ContextCompat.getColor(context!!, R.color.white))

        if (selectedPosition == holder.adapterPosition) {
            holder.binding.pic.setBackgroundResource(0)
            holder.binding.mainLayout.setBackgroundResource(R.drawable.blue_bg)
            holder.binding.title.visibility = View.VISIBLE
        } else {
            holder.binding.pic.setBackgroundResource(R.drawable.grey_bg)
            holder.binding.mainLayout.setBackgroundResource(0)
            holder.binding.title.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class Viewholder(val binding: ViewholderCategoryBinding) : RecyclerView.ViewHolder(
        binding.root
    )
}
