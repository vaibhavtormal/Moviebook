package com.vaibhav.moviebook.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vaibhav.moviebook.databinding.ViewholderCategoryBinding

class CategoryEachFilmAdapter(private val items:List<String>):
    RecyclerView.Adapter<CategoryEachFilmAdapter.Viewholder>(){
    class Viewholder (val binding: ViewholderCategoryBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryEachFilmAdapter.Viewholder {
        val binding = ViewholderCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Viewholder(binding)
    }
    override fun onBindViewHolder(holder: CategoryEachFilmAdapter.Viewholder, position: Int) {
        holder.binding.titleText.text = items[position]
    }

    override fun getItemCount(): Int = items.size
}