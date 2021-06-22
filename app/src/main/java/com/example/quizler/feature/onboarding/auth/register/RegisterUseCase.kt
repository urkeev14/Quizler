package com.example.quizler.feature.onboarding.auth.register

import com.example.quizler.domain.data.local.LocalRepository
import com.example.quizler.domain.data.remote.RemoteRepository
import com.example.quizler.domain.data.remote.request.RegisterRequestBody
import javax.inject.Inject

class RegisterUseCase
@Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository,
    private val registerResponseHandler: RegisterResponseHandler
) {

    suspend fun register(requestBody: RegisterRequestBody): RegisterOutcome {
        remoteRepository.register(requestBody).let { response ->
            if (response.isSuccessful) {
                val body = response.body()
                localRepository.cachePlayerData(body!!.playerId, body.token)
            }
            return registerResponseHandler.getRegisterOutcome(response.code())
        }
    }
}
