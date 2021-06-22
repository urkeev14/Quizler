package com.example.quizler.feature.onboarding.auth.register

data class RegisterBindingModel(
    var isEmailValid: Boolean = false,
    var isEmailAvailable: Boolean = true,
    var isUsernameValid: Boolean = false,
    var isPasswordValid: Boolean = false,
)
