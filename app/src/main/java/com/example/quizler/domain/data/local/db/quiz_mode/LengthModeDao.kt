package com.example.quizler.domain.data.local.db.quiz_mode

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.quizler.domain.data.local.db.BaseDao
import com.example.quizler.domain.data.local.entity.LengthModeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LengthModeDao : BaseDao<LengthModeEntity>{

    @Query("SELECT * FROM length")
    fun readAll(): Flow<List<LengthModeEntity>>

    @Query("DELETE FROM length")
    suspend fun deleteAll()
}
