package com.example.daggertest.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<T>(
    private var items: ArrayList<T> = arrayListOf()
) : RecyclerView.Adapter<BaseViewHolder<T>>() {

    abstract fun setViewHolder(parent: ViewGroup, viewType: Int) : BaseViewHolder<T>
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        return setViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}