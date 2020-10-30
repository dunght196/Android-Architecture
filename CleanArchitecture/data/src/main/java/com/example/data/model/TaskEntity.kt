package com.example.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.model.TaskEntity.Companion.TABLE_NAME
import com.example.domain.model.Task

@Entity(tableName = TABLE_NAME)
data class TaskEntity (
    @PrimaryKey
    @ColumnInfo(name = FIELD_ID) val id: Long,
    @ColumnInfo(name = FIELD_TITLE) val title: String,
    @ColumnInfo(name = FIELD_IS_DONE) val isDone: Boolean
) {
    companion object {
        const val TABLE_NAME = "tbl_tasks"
        const val FIELD_ID = "id"
        const val FIELD_TITLE = "title"
        const val FIELD_IS_DONE = "is_done"
    }
}

class TaskEnityMapper : EntityMapper<Task, TaskEntity> {
    override fun mapToDomain(data: TaskEntity): Task {
        return Task(
            id = data.id,
            title = data.title,
            isDone = data.isDone
        )
    }

    override fun mapToData(domain: Task): TaskEntity {
        return TaskEntity(
            id = domain.id,
            title = domain.title,
            isDone = domain.isDone
        )
    }

}