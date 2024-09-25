package com.vaibhav.moviebook.Adapter
import android.content.Intent
import android.telecom.Call.Details
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.vaibhav.moviebook.Activity.FilmDetailsActivity
import com.vaibhav.moviebook.Model.Film
import com.vaibhav.moviebook.databinding.ViewholderFilmBinding


class FlimListAdapter(private val items:ArrayList<Film>):RecyclerView.Adapter<FlimListAdapter.Viewholder>() {
    private var context:android.content.Context?= null
    inner class Viewholder(private val binding: ViewholderFilmBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(film: Film){
            binding.nameTxt.text= film.Title
            val requestOptions = RequestOptions()
                .transform(CenterCrop(),RoundedCorners(30))
            Glide.with(context!!)
                .load(film.Poster)
                .apply(requestOptions)
                .into(binding.pic)
            binding.root.setOnClickListener {
               val intent = Intent(context,FilmDetailsActivity::class.java)
                intent.putExtra("object",film)
                context!!.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlimListAdapter.Viewholder {
        context = parent.context
        val binding = ViewholderFilmBinding.inflate(LayoutInflater.from(context),parent,false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: FlimListAdapter.Viewholder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}