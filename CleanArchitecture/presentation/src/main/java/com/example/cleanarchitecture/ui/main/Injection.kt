package com.example.cleanarchitecture.ui.main

import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchitecture.entity.TaskItemMapper
import com.example.data.local.TaskDatabase
import com.example.data.local.TaskLocalDataSource
import com.example.data.model.TaskEnityMapper
import com.example.data.repository.TaskRepositoryImpl
import com.example.domain.usecase.CreateTaskUseCase
import com.example.domain.usecase.GetTaskUseCase

object Injection {
    lateinit var activity: AppCompatActivity

    val database by lazy { TaskDatabase.getInstance(activity.applicationContext) }

    val mapper by lazy { TaskEnityMapper() }

    val itemMapper by lazy { TaskItemMapper() }

    val localDataSource by lazy {
        TaskLocalDataSource(
            database.taskDAO(),
            mapper
        )
    }

    val repository by lazy { TaskRepositoryImpl(localDataSource) }

    val createTaskUseCase by lazy { CreateTaskUseCase(repository) }

    val getTaskUseCase by lazy { GetTaskUseCase(repository) }

    fun inject(mainActivity: MainActivity) {
        activity = mainActivity
        mainActivity.viewModel = TaskViewModelFactory(
            getTaskUseCase,
            createTaskUseCase,
            itemMapper,
            mainActivity
        ).create(TaskViewModel::class.java)
    }

}