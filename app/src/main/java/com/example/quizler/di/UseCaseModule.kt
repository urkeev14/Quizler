package com.example.quizler.di

import com.example.quizler.domain.data.remote.RemoteRepository
import com.example.quizler.feature.main.home.quiz_mode.QuizModeMapper
import com.example.quizler.feature.main.home.quiz_mode.QuizModeMockDataProvider
import com.example.quizler.feature.main.home.quiz_mode.usecase.GetQuizModeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetModesUseCase(
        repository: RemoteRepository,
        mapper: QuizModeMapper,
        dataProvider: QuizModeMockDataProvider
    ) = GetQuizModeUseCase(repository, mapper, dataProvider)

    @Provides
    @Singleton
    fun provideQuizModeMockDataProvider() = QuizModeMockDataProvider()

}