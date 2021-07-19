package com.example.quizler.domain.data.remote.service.quiz_mode

import com.example.quizler.domain.model.CategoryModeDto
import com.example.quizler.domain.model.DifficultyModeDto
import com.example.quizler.domain.model.LengthModeDto
import retrofit2.http.GET

interface QuizModeService {

    @GET("mode/categories")
    suspend fun getCategoryModes(): List<CategoryModeDto>

    @GET("mode/length")
    suspend fun getLengthModes(): List<LengthModeDto>

    @GET("mode/difficulty")
    suspend fun getDifficultyModes(): List<DifficultyModeDto>
}
