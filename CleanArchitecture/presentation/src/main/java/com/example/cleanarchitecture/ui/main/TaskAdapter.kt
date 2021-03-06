package com.example.cleanarchitecture.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.entity.TaskItem

class TaskAdapter(
    private val tasks: MutableList<TaskItem>,
    private val onClick: (TaskItem) -> Any?
) : RecyclerView.Adapter<TaskAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_task, parent, false)
        return ViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(tasks[position])
    }

    fun addTask(addedTask: TaskItem) {
        tasks.add(addedTask)
        notifyItemInserted(itemCount - 1)
    }

    override fun getItemCount() = tasks.size

    class ViewHolder constructor(
        view: View,
        onClick: (TaskItem) -> Any?
    ) : RecyclerView.ViewHolder(view) {
        private lateinit var task: TaskItem
        private var textPosition: TextView
        private var textTaskName: TextView

        init {
            textPosition = view.findViewById(R.id.textPosition)
            textTaskName = view.findViewById(R.id.textTaskName)
            view.setOnClickListener {
                onClick?.let { callback ->
                    callback(task)
                }
            }
        }

        fun bindData(task: TaskItem) {
            if (task == null) return
            this.task = task
            textPosition.text = "${adapterPosition +1}"
            textTaskName.text = task.title
        }
    }
}