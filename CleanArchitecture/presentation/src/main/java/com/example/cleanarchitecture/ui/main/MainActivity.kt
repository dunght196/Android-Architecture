package com.example.cleanarchitecture.ui.main

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.entity.TaskItem
import com.example.domain.model.Task
import com.example.domain.usecase.CreateTaskUseCase
import com.example.domain.usecase.GetTaskUseCase

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: TaskViewModel
    lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Injection.inject(this)
        observerTasks()
        initListener()
    }

    private fun initListener() {
        findViewById<Button>(R.id.buttonCreateTask).setOnClickListener {
            val title = findViewById<EditText>(R.id.editTaskName).text.toString()
            viewModel.addTask(title)
        }
    }

    private fun observerTasks() {
        viewModel.tasks.observe(this@MainActivity, Observer { task ->
            displayTasks(task)
        })

        viewModel.addedTask.observe(this@MainActivity, { addedTask ->
            displayAddedTask(addedTask)
        })
    }

    private fun displayAddedTask(addedTask: TaskItem) {
        taskAdapter.addTask(addedTask)
    }

    private fun displayTasks(tasks: List<TaskItem>) {
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_tasks)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            taskAdapter = TaskAdapter(tasks.toMutableList()) { item ->
                toast(item.title)
            }
            adapter = taskAdapter
        }
    }
}

fun Context.toast(messsage: String) {
    Toast.makeText(
        this,
        messsage,
        Toast.LENGTH_LONG
    ).show()
}