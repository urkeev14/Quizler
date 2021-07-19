package com.example.quizler.di.app

import com.example.quizler.domain.data.local.QuizModeRepository
import com.example.quizler.domain.data.remote.RemoteRepository
import com.example.quizler.feature.main.home.quiz_mode.mapper.CategoryModeMapper
import com.example.quizler.feature.main.home.quiz_mode.mapper.DifficultyModeMapper
import com.example.quizler.feature.main.home.quiz_mode.mapper.LengthModeMapper
import com.example.quizler.feature.main.home.quiz_mode.usecase.GetModesCategoryUseCase
import com.example.quizler.feature.main.home.quiz_mode.usecase.GetModesDifficultyUseCase
import com.example.quizler.feature.main.home.quiz_mode.usecase.GetModesLengthUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideCategoryModeMapper() = CategoryModeMapper()

    @Provides
    @Singleton
    fun provideLengthModeMapper() = LengthModeMapper()

    @Provides
    @Singleton
    fun provideDifficultyModeMapper() = DifficultyModeMapper()

    @Provides
    @Singleton
    fun provideGetModesCategoryUseCase(
        remoteRepository: RemoteRepository,
        localRepository: QuizModeRepository,
        mapper: CategoryModeMapper
    ) = GetModesCategoryUseCase(remoteRepository, localRepository, mapper)

    @Provides
    @Singleton
    fun provideGetModesLengthUseCase(
        remoteRepository: RemoteRepository,
        localRepository: QuizModeRepository,
        mapper: LengthModeMapper
    ) = GetModesLengthUseCase(remoteRepository, localRepository, mapper)

    @Provides
    @Singleton
    fun provideGetModesDifficultyUseCase(
        remoteRepository: RemoteRepository,
        localRepository: QuizModeRepository,
        mapper: DifficultyModeMapper
    ) = GetModesDifficultyUseCase(remoteRepository, localRepository, mapper)
}
