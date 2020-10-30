package com.example.data.local

import com.example.data.model.EntityMapper
import com.example.data.model.TaskEnityMapper
import com.example.data.model.TaskEntity
import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository
import kotlin.random.Random

class TaskLocalDataSource(
    private val taskDAO: TaskDAO,
    private val mapper: TaskEnityMapper
) : TaskRepository {
    override fun getTasks(): List<Task> {
        return taskDAO.getTasks().map {
            mapper.mapToDomain(it)
        };
    }

    override fun createTask(title: String, isDone: Boolean): Task {
        val id = Random.nextLong()
        val task = TaskEntity(id, title, isDone)
        taskDAO.createTask(task)
        return mapper.mapToDomain(task)
    }

    override fun isExistTask(title: String): Boolean {
        return taskDAO.isExist(title) != null
    }
}