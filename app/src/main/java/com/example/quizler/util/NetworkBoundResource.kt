package com.example.quizler.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

/**
 * It starts by observing the database for the resource. When the entry is loaded from the database
 * for the first time, NetworkBoundResource checks whether the result is good enough to be dispatched
 * or that it should be re-fetched from the network. Note that both of these situations can happen
 * at the same time, given that you probably want to show cached data while updating it from the network.
 *
 * If the network call completes successfully, it saves the response into the database
 * and re-initializes the stream. If network request fails, the NetworkBoundResource
 * dispatches a failure directly.
 */
inline fun <ResultType, RequestType> networkBoundResource(
    crossinline query: () -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline shouldFetch: (ResultType) -> Boolean = { true }
) = flow {

    val data = query().first()

    val flow = if (shouldFetch(data)) {
        emit(State.Loading(data))

        try {
            saveFetchResult(fetch())
            query().map { State.Success(it) }
        } catch (throwable: Throwable) {
            query().map { State.Error(throwable, it) }
        }
    } else {
        query().map { State.Success(it) }
    }

    emitAll(flow)
}
