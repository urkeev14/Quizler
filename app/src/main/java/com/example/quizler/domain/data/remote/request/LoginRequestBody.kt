package com.example.quizler.domain.data.remote.request

import com.google.gson.annotations.SerializedName

data class LoginRequestBody(
    @SerializedName("email") val username: String,
    val password: String,
)
