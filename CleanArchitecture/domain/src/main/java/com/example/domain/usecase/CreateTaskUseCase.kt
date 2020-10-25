package com.example.domain.usecase

import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository

class CreateTaskUseCase constructor(
    private val respository: TaskRepository
) : UseCase<CreateTaskUseCase.Param, Task> {
    /**
     * 1. Task must start with "Make money"
     * 2. Maximum character = 500
     * 3. Min character = 10
     * 4. Task can not be duplicate
     */

    override fun execute(param: Param): Task {
        return respository.createTask(param.title, param.isDone)
    }

    companion object {
        const val TITLE_PREFIX = "Make money"
        const val TITLE_MIN_LENGTH = "10"
        const val TITLE_MAX_LENGTH = "500"
        const val ERROR_PREFIX = "Task name must be start with $TITLE_PREFIX"
        const val ERROR_MIN_CHARACTER = "Task name length can not be less than $TITLE_MIN_LENGTH"
        const val ERROR_MAX_CHARACTER = "Task name length can not be greater than $TITLE_MAX_LENGTH"
    }

    data class Param(val title: String, val isDone: Boolean = false)

}