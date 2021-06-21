package com.example.quizler.util

import com.example.quizler.domain.data.RepositoryResponse
import retrofit2.Response

suspend fun <T> executeNetworkAction(load: suspend () -> Response<T>): RepositoryResponse<T> {
    return load().let { response ->
        if (response.isSuccessful) {
            RepositoryResponse.Success(response.body()!!)
        } else {
            RepositoryResponse.Failure(Throwable(response.message()))
        }
    }
}
