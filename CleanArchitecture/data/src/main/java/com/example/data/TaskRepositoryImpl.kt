package com.example.data

import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository

class TaskRepositoryImpl : TaskRepository {
    override fun getTasks(): List<Task> {
        TODO("Not yet implemented")
    }

    override fun createTask(title: String, isDone: Boolean): Task {
        TODO("Not yet implemented")
    }

    override fun isExistTask(title: String): Boolean {
        TODO("Not yet implemented")
    }
}