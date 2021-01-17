package com.example.daggertest.home.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.daggertest.R
import com.example.daggertest.base.BaseRecyclerViewAdapter
import com.example.daggertest.base.BaseViewHolder
import com.example.daggertest.network.response.MoviePopularInfo

class MoviePopularAdapter : BaseRecyclerViewAdapter<MoviePopularInfo>() {

    override fun setViewHolder(view: View): BaseViewHolder<MoviePopularInfo> {
        return TestViewHolder(view)
    }

    inner class TestViewHolder(containerView: View) : BaseViewHolder<MoviePopularInfo>(containerView) {
        private val title: TextView? = itemView.findViewById(R.id.tv_title)
        private val overview: TextView? = itemView.findViewById(R.id.tv_over_view)

        override fun bind(item: MoviePopularInfo) {
            title?.text = item.original_title
            overview?.text = item.overview
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.item_movie
    }

}