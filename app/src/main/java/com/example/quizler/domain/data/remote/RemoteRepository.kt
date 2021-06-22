package com.example.quizler.domain.data.remote

import com.example.quizler.domain.data.remote.request.LoginRequestBody
import com.example.quizler.domain.data.remote.request.RegisterRequestBody
import com.example.quizler.domain.data.remote.service.player.PlayerService
import com.example.quizler.domain.model.Player

class RemoteRepository(
    private val playerService: PlayerService
) {

    suspend fun register(body: RegisterRequestBody) = playerService.register(body)
    suspend fun login(body: LoginRequestBody) = playerService.login(body)
}
