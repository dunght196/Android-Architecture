package com.example.daggertest.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.daggertest.R

abstract class BaseRecyclerViewAdapter<T>(
    private var listData: ArrayList<T> = arrayListOf()
) : RecyclerView.Adapter<BaseViewHolder<T>>() {

    abstract fun setViewHolder(view: View): BaseViewHolder<T>

    abstract fun getLayoutId(): Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        val view = LayoutInflater.from(parent.context)
            .inflate(getLayoutId(), parent, false)
        return setViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size

    fun appendData(items: MutableList<T>) {
        listData.clear()
        listData.addAll(items)
        notifyDataSetChanged()
    }
}