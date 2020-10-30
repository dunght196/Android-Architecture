package com.example.data.repository

import com.example.data.local.TaskLocalDataSource
import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository

class TaskRepositoryImpl(
    private val localDataSource: TaskRepository
) : TaskRepository {
    override fun getTasks(): List<Task> = localDataSource.getTasks()

    override fun createTask(title: String, isDone: Boolean): Task = localDataSource.createTask(title, isDone)

    override fun isExistTask(title: String): Boolean  = localDataSource.isExistTask(title)
}