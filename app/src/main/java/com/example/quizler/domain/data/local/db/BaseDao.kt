package com.example.quizler.domain.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface BaseDao<T> {

    @Insert
    suspend fun insert(data: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    suspend fun insert(data: List<T>)

    @Delete
    suspend fun delete(data: T)
}
