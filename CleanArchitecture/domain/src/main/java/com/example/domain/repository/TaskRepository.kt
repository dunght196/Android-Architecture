package com.example.domain.repository

import com.example.domain.model.Task

interface TaskRepository {
    fun getTasks(): List<Task>

    fun createTask(title: String, isDone: Boolean) : Task

    fun isExistTask(title: String): Boolean
}