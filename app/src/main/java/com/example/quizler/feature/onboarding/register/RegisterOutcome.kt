package com.example.quizler.feature.onboarding.register

import androidx.annotation.StringRes

data class RegisterOutcome(
    val isSuccessful: Boolean,
    @StringRes val errorResId: Int? = null
)
