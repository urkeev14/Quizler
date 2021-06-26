package com.example.quizler.feature.onboarding.register

data class RegisterBindingModel(
    var isEmailValid: Boolean = false,
    var isEmailAvailable: Boolean = true,
    var isUsernameValid: Boolean = false,
    var isPasswordValid: Boolean = false,
)
