package com.example.domain.usecase

import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository

class GetTaskUseCase constructor(
        private val repository: TaskRepository
) : WithoutParamUseCase<List<Task>> {

    override fun execute(): List<Task> {
        return repository.getTasks()
    }

}