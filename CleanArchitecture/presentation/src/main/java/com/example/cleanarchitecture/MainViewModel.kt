package com.example.cleanarchitecture

import com.example.domain.usecase.CreateTaskUseCase
import com.example.domain.usecase.GetTaskUseCase

class MainViewModel(
    private val createTaskUseCase: CreateTaskUseCase,
    private val getTaskUseCase: GetTaskUseCase
) {

    fun getTasks() {
        getTaskUseCase.execute()
    }

    fun createTask(title: String) {
        createTaskUseCase.execute(CreateTaskUseCase.Param(title))
    }
}