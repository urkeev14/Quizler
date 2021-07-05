package com.example.quizler.domain.data.remote.service.quiz_mode

import com.example.quizler.domain.data.response.QuizModeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface QuizModeService {

    @GET("/mode/{mode_name}")
    suspend fun getModes(@Path("mode_name") modeName: String): Response<QuizModeResponse>

}