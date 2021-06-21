package com.example.quizler.domain.data.remote

import com.example.quizler.domain.data.remote.service.player.PlayerService
import com.example.quizler.domain.model.Player

class RemoteRepository(
    private val playerService: PlayerService
) {

    suspend fun register(player: Player) = playerService.register(player)
}
