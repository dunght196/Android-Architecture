package com.example.data.local

import android.content.Context
import androidx.room.*
import com.example.data.local.TaskDatabase.Companion.DATABASE_VERSION
import com.example.data.model.TaskEntity
import com.example.data.model.TaskEntity.Companion.FIELD_TITLE
import com.example.data.model.TaskEntity.Companion.TABLE_NAME

@Dao
interface TaskDAO {
    @Query("SELECT * FROM $TABLE_NAME")
    fun getTasks(): List<TaskEntity>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun createTask(task: TaskEntity)

    @Query("SELECT * FROM $TABLE_NAME WHERE $FIELD_TITLE = :title")
    fun isExist(title: String): TaskEntity?

    @Insert
    fun insertTask(task: TaskEntity)
}

@Database(
    entities = arrayOf(TaskEntity::class),
    version = DATABASE_VERSION
)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDAO(): TaskDAO

    companion object {
        const val  DATABASE_VERSION = 1;
        const val  DATABASE_NAME = "task.db";
        fun getInstance(context: Context) = Room.databaseBuilder(
            context,
            TaskDatabase::class.java,
            DATABASE_NAME
        )
        .allowMainThreadQueries()
        .build()
    }
}