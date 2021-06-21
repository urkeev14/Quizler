package com.example.quizler.domain.data.remote.service.player

import com.example.quizler.domain.data.response.RegisterResponse
import com.example.quizler.domain.model.Player
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface PlayerService {

    @POST("register")
    fun register(@Body player: Player): Response<RegisterResponse>
}
