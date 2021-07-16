package com.example.quizler.feature.main.home.quiz_mode.usecase

import com.example.quizler.domain.data.RepositoryResponse
import com.example.quizler.domain.data.remote.RemoteRepository
import com.example.quizler.domain.model.QuizMode
import com.example.quizler.domain.model.QuizModeDto
import com.example.quizler.feature.main.home.quiz_mode.QuizModeMapper
import com.example.quizler.feature.main.home.quiz_mode.QuizModeMockDataProvider
import com.example.quizler.util.State
import com.example.quizler.util.executeNetworkAction

class GetQuizModeUseCase(
    private val repository: RemoteRepository,
    private val mapper: QuizModeMapper
) {

    suspend fun getModes(modeName: String): State<List<QuizMode>> {
        return when (val result = executeNetworkAction { repository.getModes(modeName) }) {
            is RepositoryResponse.Success -> handleSuccess(result.data)
            is RepositoryResponse.Failure -> handleFailure(modeName, result.throwable)
        }
    }

    private fun handleFailure(modeName: String, throwable: Throwable): State<List<QuizMode>> {
        return State.Error(
//            data = quizModeMockDataProvider.mockedModes[modeName]?.map { mapper.map(it) },
            data = emptyList(),
            throwable = throwable
        )
    }

    private fun handleSuccess(data: List<QuizModeDto>): State<List<QuizMode>> {
        return State.Success(data.map { mapper.map(it) })
    }
}
