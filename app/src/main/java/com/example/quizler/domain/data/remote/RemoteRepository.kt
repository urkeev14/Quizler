package com.example.quizler.domain.data.remote

import com.example.quizler.domain.data.remote.request.LoginRequestBody
import com.example.quizler.domain.data.remote.request.RegisterRequestBody
import com.example.quizler.domain.data.remote.service.player.PlayerService
import com.example.quizler.domain.data.remote.service.quiz_mode.QuizModeService

class RemoteRepository(
    private val playerService: PlayerService,
    private val quizModeService: QuizModeService
) {

    suspend fun register(body: RegisterRequestBody) = playerService.register(body)
    suspend fun login(body: LoginRequestBody) = playerService.login(body)

    suspend fun getCategoryModes() = quizModeService.getCategoryModes()
    suspend fun getLengthModes() = quizModeService.getLengthModes()
    suspend fun getDifficultyModes() = quizModeService.getDifficultyModes()
}
