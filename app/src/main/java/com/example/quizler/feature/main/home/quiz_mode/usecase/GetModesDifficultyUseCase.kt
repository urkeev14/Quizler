package com.example.quizler.feature.main.home.quiz_mode.usecase

import androidx.room.withTransaction
import com.example.quizler.domain.data.local.QuizModeRepository
import com.example.quizler.domain.data.remote.RemoteRepository
import com.example.quizler.domain.model.DifficultyModeDto
import com.example.quizler.feature.main.home.quiz_mode.mapper.DifficultyModeMapper
import com.example.quizler.util.networkBoundResource

class GetModesDifficultyUseCase(
    private val remoteRepository: RemoteRepository,
    private val quizModeRepository: QuizModeRepository,
    private val mapper: DifficultyModeMapper
) {

    fun fetch() = networkBoundResource(
        query = {
            quizModeRepository.readDifficultyModes()
        },
        fetchData = {
            remoteRepository.getDifficultyModes()
        },
        cache = {
            quizModeRepository.db.withTransaction {
                quizModeRepository.deleteDifficultyModes()
                quizModeRepository.insertDifficultyModes(mappedList(it))
            }
        },
        shouldFetch = { it.isNullOrEmpty() }
    )

    private fun mappedList(list: List<DifficultyModeDto>) = list.map { mapper.map(it) }
}
