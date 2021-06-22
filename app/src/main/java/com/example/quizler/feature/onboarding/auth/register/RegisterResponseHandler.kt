package com.example.quizler.feature.onboarding.auth.register

import com.example.quizler.R

private const val CODE_SUCCESS = 200
private const val CODE_ERROR_EMAIL_EXIST = 401
private const val CODE_ERROR_USERNAME_EXIST = 402
private const val CODE_ERROR_SERVER_DOWN = 500

class RegisterResponseHandler {
    fun getRegisterOutcome(responseCode: Int): RegisterOutcome = when (responseCode) {
        CODE_SUCCESS -> RegisterOutcome(true)
        CODE_ERROR_EMAIL_EXIST -> RegisterOutcome(false, R.string.error_email_exist)
        CODE_ERROR_USERNAME_EXIST -> RegisterOutcome(false, R.string.error_username_exist)
        CODE_ERROR_SERVER_DOWN -> RegisterOutcome(false, R.string.error_server_down)
        else -> RegisterOutcome(false, R.string.error_unknow)
    }
}
