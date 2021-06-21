package com.example.quizler.feature.onboarding.auth.register

import com.example.quizler.util.Event

data class RegisterBindingModel(
    var isEmailValid: Boolean = false,
    var isEmailAvailable: Boolean = true,
    var isUsernameValid: Boolean = false,
    var isPasswordValid: Boolean = false,
    val isLoading: Boolean = false,
    val isRegisterSuccess: Boolean = false,
    val errorMessage: Event<Int?> = Event(null)
)
