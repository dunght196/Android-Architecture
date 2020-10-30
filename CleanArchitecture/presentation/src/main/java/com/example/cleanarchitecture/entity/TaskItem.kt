package com.example.cleanarchitecture.entity

import com.example.cleanarchitecture.base.ItemMapper
import com.example.domain.model.Task

data class TaskItem(
    val id: Long,
    val title: String,
    val isDone: Boolean,
)

class TaskItemMapper : ItemMapper<Task, TaskItem> {
    override fun mapToPresentation(domainModel: Task): TaskItem {
        return TaskItem(
            id = domainModel.id,
            title = domainModel.title,
            isDone = domainModel.isDone
        )
    }

    override fun mapToDomain(itemModel: TaskItem): Task {
        return Task(
            id = itemModel.id,
            title = itemModel.title,
            isDone = itemModel.isDone
        )
    }

}