package com.example.quizler.domain.data.local.db.quiz_mode

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.quizler.domain.data.local.db.BaseDao
import com.example.quizler.domain.data.local.entity.CategoryModeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryModeDao: BaseDao<CategoryModeEntity> {

    @Query("SELECT * FROM category")
    fun readAll(): Flow<List<CategoryModeEntity>>

    @Query("DELETE FROM category")
    suspend fun deleteAll()
}
