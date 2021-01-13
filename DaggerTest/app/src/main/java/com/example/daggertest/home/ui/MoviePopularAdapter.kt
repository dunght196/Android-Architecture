package com.example.daggertest.home.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.daggertest.R
import com.example.daggertest.network.response.MoviePopularInfo

class MoviePopularAdapter(
    var listMovies: MutableList<MoviePopularInfo> = mutableListOf()
) : RecyclerView.Adapter<MoviePopularAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listMovies[position])
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView? = itemView.findViewById(R.id.tv_title)
        private val overview: TextView? = itemView.findViewById(R.id.tv_over_view)

        fun bind(item: MoviePopularInfo?) {
            title?.text = item?.original_title
            overview?.text = item?.overview
        }
    }

    fun appendData(items: MutableList<MoviePopularInfo>) {
        listMovies.clear()
        listMovies.addAll(items)
        notifyDataSetChanged()
    }

}