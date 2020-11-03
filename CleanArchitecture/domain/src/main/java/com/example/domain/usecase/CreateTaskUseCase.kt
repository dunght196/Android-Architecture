package com.example.domain.usecase

import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository
import com.example.domain.usecase.CreateTaskUseCase.ErrorMessage.TASK_EXIST
import java.lang.IllegalArgumentException

class CreateTaskUseCase constructor(
    private val taskRepository: TaskRepository
) : UseCase<CreateTaskUseCase.Param, Task> {
    /**
     * If title is empty throw exception
     * If this task is exist, throw an exeption
     */
    override fun execute(param: Param): Task {
        if (param.title.isEmpty()) {
            throw IllegalArgumentException(ErrorMessage.TITLE_EMPTY)
        }
        if (taskRepository.isExistTask(param.title)) {
            throw TitleExistExeption(TASK_EXIST)
        }
        return taskRepository.createTask(param.title, param.isDone)
    }

    data class Param(val title: String, val isDone: Boolean = false)

    class TitleExistExeption(message: String) : Exception(message)

    object ErrorMessage {
        const val TITLE_EMPTY = "Title must not be empty"
        const val TASK_EXIST = "Task is exist"
    }

}