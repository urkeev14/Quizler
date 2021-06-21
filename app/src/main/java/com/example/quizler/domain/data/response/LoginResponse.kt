package com.example.quizler.domain.data.response

data class LoginResponse(
    val playerId: String,
    val token: String,
    val isAdmin: Boolean,
)
