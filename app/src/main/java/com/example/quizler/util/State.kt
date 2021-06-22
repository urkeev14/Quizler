package com.example.quizler.util

sealed class State<T>(
    val data: T? = null,
    val error: Throwable? = null
) {
    class Success<T>(data: T) : State<T>(data)
    class Loading<T>(data: T? = null) : State<T>(data)
    class Error<T>(throwable: Throwable? = null, data: T? = null) : State<T>(data, throwable)
}
