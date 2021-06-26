package com.example.quizler.feature.onboarding.register

import com.example.quizler.R

private const val CODE_ERROR_EMAIL_EXIST = 401
private const val CODE_ERROR_USERNAME_EXIST = 402
private const val CODE_ERROR_SERVER_DOWN = 500

class RegisterResponseHandler {
    fun getRegisterErrorMessageResId(responseCode: Int): Int = when (responseCode) {
        CODE_ERROR_EMAIL_EXIST -> R.string.error_email_exist
        CODE_ERROR_USERNAME_EXIST -> R.string.error_username_exist
        CODE_ERROR_SERVER_DOWN -> R.string.error_server_down
        else -> R.string.error_unknow
    }
}
