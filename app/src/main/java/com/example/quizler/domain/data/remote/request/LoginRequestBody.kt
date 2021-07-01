package com.example.quizler.domain.data.remote.request

import com.google.gson.annotations.SerializedName

data class LoginRequestBody(
    val username: String,
    val password: String,
)
