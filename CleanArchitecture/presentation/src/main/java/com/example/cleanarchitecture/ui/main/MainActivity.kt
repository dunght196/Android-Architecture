package com.example.cleanarchitecture.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cleanarchitecture.R
import com.example.domain.model.Task
import com.example.domain.usecase.CreateTaskUseCase
import com.example.domain.usecase.GetTaskUseCase

class MainActivity : AppCompatActivity() {
    lateinit var createTaskUseCase: CreateTaskUseCase
    lateinit var getTaskUseCase: GetTaskUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tasks: List<Task> = getTaskUseCase.execute()
    }
}