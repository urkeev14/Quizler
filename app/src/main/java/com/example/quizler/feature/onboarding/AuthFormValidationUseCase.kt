package com.example.quizler.feature.onboarding

/**
 *^                 # start-of-string
 *(?=.*[0-9])       # a digit must occur at least once
 *(?=.*[a-z])       # a lower case letter must occur at least once
 *(?=.*[A-Z])       # an upper case letter must occur at least once
 *(?=.*[@#$%^&+=])  # a special character must occur at least once
 *(?=\S+$)          # no whitespace allowed in the entire string
 *.{8,}             # anything, at least eight places though
 *$                 # end-of-string
 */
private const val REGEX_PASSWORD =
    "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%!\\-_?&])(?=\\S+\$).{8,}"
private const val REGEX_USERNAME = "^[a-zA-Z0-9._]{5,}\$"
private const val REGEX_EMAIL =
    "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?!-)(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"
private const val MIN_LENGTH_USERNAME = 5
private const val MIN_LENGTH_PASSWORD = 8

class AuthFormValidationUseCase {
    fun validateLoginUsername(username: String): Boolean = username.length >= MIN_LENGTH_USERNAME
    fun validateLoginPassword(password: String): Boolean = password.length >= MIN_LENGTH_PASSWORD
    fun validateRegisterUsername(username: String): Boolean = username.matches(Regex(REGEX_USERNAME))
    fun validateRegisterPassword(password: String): Boolean = password.matches(Regex(REGEX_PASSWORD))
    fun validateRegisterEmail(email: String): Boolean = email.matches(Regex(REGEX_EMAIL))
}
