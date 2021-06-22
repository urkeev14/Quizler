package com.example.quizler.domain.data.remote.service.player

import com.example.quizler.domain.data.remote.request.LoginRequestBody
import com.example.quizler.domain.data.remote.request.RegisterRequestBody
import com.example.quizler.domain.data.response.LoginResponse
import com.example.quizler.domain.data.response.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface PlayerService {

    @POST("register")
    suspend fun register(@Body registerRequest: RegisterRequestBody): Response<RegisterResponse>

    @POST("login")
    suspend fun login(@Body loginRequestBody: LoginRequestBody): Response<LoginResponse>
}
