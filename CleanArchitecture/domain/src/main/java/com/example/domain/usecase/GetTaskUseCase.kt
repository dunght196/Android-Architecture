package com.example.domain.usecase

import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository

class GetTaskUseCase constructor(
    private val repository: TaskRepository
) : WithoutParamUseCase<List<Task>> {
    /**
     * Get latest 5 reccent task
     */
    override fun execute(): List<Task> {
        return  repository.getTasks().subList(0, MAXIMUM_TASK)
    }

    companion object {
        const val  MAXIMUM_TASK = 5
    }
}