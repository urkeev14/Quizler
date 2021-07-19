package com.example.quizler.feature.main.home.quiz_mode.usecase

import androidx.room.withTransaction
import com.example.quizler.domain.data.local.QuizModeRepository
import com.example.quizler.domain.data.local.entity.CategoryModeEntity
import com.example.quizler.domain.data.remote.RemoteRepository
import com.example.quizler.domain.model.CategoryModeDto
import com.example.quizler.feature.main.home.quiz_mode.mapper.CategoryModeMapper
import com.example.quizler.util.networkBoundResource

class GetModesCategoryUseCase(
    private val remoteRepository: RemoteRepository,
    private val quizModeRepository: QuizModeRepository,
    private val mapper: CategoryModeMapper
) {

    fun fetch() = networkBoundResource(
        query = {
            quizModeRepository.readCategoriesModes()
        },
        fetchData = {
            remoteRepository.getCategoryModes()
        },
        cache = {
            quizModeRepository.db.withTransaction {
                quizModeRepository.deleteCategoriesModes()
                quizModeRepository.insertCategoriesModes(map(it))
            }
        },
        shouldFetch = { it.isNullOrEmpty() }
    )

    private fun map(list: List<CategoryModeDto>): List<CategoryModeEntity> {
        return list.map { item -> mapper.map(item) }
    }
}
