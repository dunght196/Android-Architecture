package com.example.daggertest.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.daggertest.R
import com.example.daggertest.recyclerview.FooterViewHolder

abstract class BaseRecyclerViewAdapter<T>(
    private var listData: ArrayList<T> = arrayListOf(),
    private var mFooterState: Int = NONE
) : RecyclerView.Adapter<BaseViewHolder<T>>() {

    companion object {
        const val TYPE_COMMON_VIEW = -1
        const val TYPE_FOOTER_VIEW = -2
        const val NONE = -1
        const val LOADING = 0
    }

    abstract fun setViewHolder(view: View): BaseViewHolder<T>

    abstract fun getLayoutId(): Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        val viewHolder: BaseViewHolder<T>?
        val viewFooter =
            LayoutInflater.from(parent.context).inflate(R.layout.load_footer_layout, parent, false)
        val viewCommon = LayoutInflater.from(parent.context).inflate(getLayoutId(), parent, false)
        viewHolder = if (viewType == TYPE_COMMON_VIEW) {
            setViewHolder(viewCommon)
        } else {
            FooterViewHolder(viewFooter)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size

    override fun getItemViewType(position: Int): Int {
        if (isFooterView(position))
            return TYPE_FOOTER_VIEW
        return TYPE_COMMON_VIEW
    }

    private fun isFooterView(position: Int): Boolean {
        return mFooterState != NONE && position == itemCount - 1
    }

    fun prependData(items: MutableList<T>) {
        listData.clear()
        listData.addAll(items)
        notifyDataSetChanged()
    }

    fun appendData(items: MutableList<T>) {
        if (items.isNotEmpty()) {
            val position = listData.size
            listData.addAll(items)
            notifyItemRangeInserted(position, listData.size)
        }
    }

    fun setFooterState(state: Int) {
        mFooterState = state
    }


}