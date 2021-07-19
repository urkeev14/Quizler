package com.example.quizler.domain.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.quizler.domain.data.local.db.quiz_mode.QuizModeDatabase
import com.example.quizler.domain.data.local.entity.CategoryModeEntity
import com.example.quizler.domain.data.local.entity.DifficultyModeEntity
import com.example.quizler.domain.data.local.entity.LengthModeEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class QuizModeRepository(
    val db: QuizModeDatabase
) {

    fun readCategoriesModes() = db.daoCategory().readAll()
    fun readDifficultyModes() = db.daoDifficulty().readlAll()
    fun readLengthModes() = db.daoLength().readAll()

    suspend fun insertLengthModes(data: List<LengthModeEntity>) = db.daoLength().insert(data)
    suspend fun insertDifficultyModes(data: List<DifficultyModeEntity>) = db.daoDifficulty().insert(data)
    suspend fun insertCategoriesModes(data: List<CategoryModeEntity>) = db.daoCategory().insert(data)

    suspend fun deleteCategoriesModes() = db.daoCategory().deleteAll()
    suspend fun deleteLengthModes() = db.daoLength().deleteAll()
    suspend fun deleteDifficultyModes() = db.daoDifficulty().deleteAll()

}
