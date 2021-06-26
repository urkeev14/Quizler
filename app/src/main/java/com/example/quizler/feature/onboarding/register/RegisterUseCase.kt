package com.example.quizler.feature.onboarding.register

import com.example.quizler.domain.data.local.LocalRepository
import com.example.quizler.domain.data.remote.RemoteRepository
import com.example.quizler.domain.data.remote.request.RegisterRequestBody
import com.example.quizler.util.State
import javax.inject.Inject

class RegisterUseCase
@Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository,
    private val registerResponseHandler: RegisterResponseHandler
) {

    suspend fun register(requestBody: RegisterRequestBody): State<Boolean> {
        return remoteRepository.register(requestBody).let { response ->
            if (response.isSuccessful) {
                val body = response.body()
                localRepository.cachePlayerData(body!!.playerId, body.token)

                State.Success(true)
            } else {
                val messageResId = registerResponseHandler.getRegisterErrorMessageResId(response.code())
                State.Error(messageResId = messageResId)
            }
        }
    }
}
