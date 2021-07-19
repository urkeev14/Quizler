package com.example.quizler.feature.onboarding.login

import com.example.quizler.domain.data.local.QuizModeRepository
import com.example.quizler.domain.data.local.UserDataStore
import com.example.quizler.domain.data.remote.RemoteRepository
import com.example.quizler.domain.data.remote.request.LoginRequestBody
import com.example.quizler.util.State
import javax.inject.Inject

class LoginUseCase
@Inject constructor(
    private val dataStore: UserDataStore,
    private val remoteRepository: RemoteRepository,
) {

    suspend fun login(loginRequestBody: LoginRequestBody): State<Boolean> {
        return remoteRepository.login(loginRequestBody).let { response ->
            if (response.isSuccessful) {
                val body = response.body()
                dataStore.cachePlayerData(body!!.playerId, body.token)

                State.Success(true)
            } else {
                State.Error()
            }
        }
    }
}
