package com.example.cleanarchitecture.ui.main

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture.entity.TaskItem
import com.example.cleanarchitecture.entity.TaskItemMapper
import com.example.domain.usecase.CreateTaskUseCase
import com.example.domain.usecase.GetTaskUseCase

class TaskViewModel(
    private val getTaskUseCase: GetTaskUseCase,
    private val createTaskUseCase: CreateTaskUseCase,
    private val mapper: TaskItemMapper,
    private val activity: MainActivity
) : ViewModel() {

    private val _tasks = MutableLiveData<List<TaskItem>>()
    val tasks: LiveData<List<TaskItem>>
        get() = _tasks

    private val _addedTask = MutableLiveData<TaskItem>()
    val addedTask: LiveData<TaskItem>
        get() = _addedTask

    init {
        loadTasks()
    }

    private fun loadTasks() {
        val taskUseCase = getTaskUseCase
            .execute()
            .map { mapper.mapToPresentation(it) }
        _tasks.postValue(taskUseCase)
    }

    fun addTask(title: String) {
        try {
            val addedTaskUseCase = createTaskUseCase
                .execute(CreateTaskUseCase.Param(title))
            _addedTask.postValue(mapper.mapToPresentation(addedTaskUseCase))
        } catch (e: IllegalArgumentException) {
            e.message?.let { activity.toast(it) }

        } catch (e: CreateTaskUseCase.TitleExistExeption) {
            e.message?.let { activity.toast(it) }
        }
    }

}

class TaskViewModelFactory constructor(
    private val getTaskUseCase: GetTaskUseCase,
    private val createTaskUseCase: CreateTaskUseCase,
    private val mapper: TaskItemMapper,
    private val activity: MainActivity,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
            return TaskViewModel(getTaskUseCase, createTaskUseCase, mapper, activity) as T
        }
        throw IllegalArgumentException("Unknow ViewModel class")
    }

}