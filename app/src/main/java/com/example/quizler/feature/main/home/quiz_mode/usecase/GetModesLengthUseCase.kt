package com.example.quizler.feature.main.home.quiz_mode.usecase

import androidx.room.withTransaction
import com.example.quizler.domain.data.local.QuizModeRepository
import com.example.quizler.domain.data.remote.RemoteRepository
import com.example.quizler.domain.model.LengthModeDto
import com.example.quizler.feature.main.home.quiz_mode.mapper.LengthModeMapper
import com.example.quizler.util.networkBoundResource

class GetModesLengthUseCase(
    private val remoteRepository: RemoteRepository,
    private val quizModeRepository: QuizModeRepository,
    private val mapper: LengthModeMapper
) {

    fun fetch() = networkBoundResource(
        query = {
            quizModeRepository.readLengthModes()
        },
        fetchData = {
            remoteRepository.getLengthModes()
        },
        cache = {
            quizModeRepository.db.withTransaction {
                quizModeRepository.deleteLengthModes()
                quizModeRepository.insertLengthModes(mappedList(it))
            }
        },
        shouldFetch = { it.isNullOrEmpty() }
    )

    private fun mappedList(list: List<LengthModeDto>) =
        list.map { mapper.map(it) }
}
