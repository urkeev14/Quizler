package com.example.quizler.feature.onboarding.auth.register

import com.example.quizler.domain.data.local.LocalRepository
import com.example.quizler.domain.data.remote.RemoteRepository
import com.example.quizler.domain.model.Player
import javax.inject.Inject

class RegisterUseCase
@Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository,
    private val registerResponseHandler: RegisterOutcomeHandler
) {

    suspend fun register(player: Player): RegisterOutcome {
        remoteRepository.register(player).let { response ->
            if (response.isSuccessful) {
                val body = response.body()
                localRepository.cachePlayerData(body!!.playerId, body.token)
            }
            return registerResponseHandler.getRegisterOutcome(response.code())
        }
    }
}
