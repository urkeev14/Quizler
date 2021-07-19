package com.example.quizler.domain.data.local.db.quiz_mode

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.quizler.domain.data.local.entity.CategoryModeEntity
import com.example.quizler.domain.data.local.entity.DifficultyModeEntity
import com.example.quizler.domain.data.local.entity.LengthModeEntity

@Database(
    entities = [
        CategoryModeEntity::class,
        LengthModeEntity::class,
        DifficultyModeEntity::class
    ],
    version = 3,
    exportSchema = false
)
abstract class QuizModeDatabase : RoomDatabase() {
    abstract fun daoCategory(): CategoryModeDao
    abstract fun daoLength(): LengthModeDao
    abstract fun daoDifficulty(): DifficultyModeDao
}
