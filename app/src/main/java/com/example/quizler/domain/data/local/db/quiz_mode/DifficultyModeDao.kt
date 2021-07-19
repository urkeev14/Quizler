package com.example.quizler.domain.data.local.db.quiz_mode

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.quizler.domain.data.local.db.BaseDao
import com.example.quizler.domain.data.local.entity.DifficultyModeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DifficultyModeDao: BaseDao<DifficultyModeEntity> {

    @Query("SELECT * FROM difficulty")
    fun readlAll(): Flow<List<DifficultyModeEntity>>

    @Query("DELETE FROM difficulty")
    suspend fun deleteAll()
}
