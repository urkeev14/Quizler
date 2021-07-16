package com.example.quizler.di.app

import com.example.quizler.domain.data.remote.RemoteRepository
import com.example.quizler.feature.main.home.quiz_mode.QuizModeMapper
import com.example.quizler.feature.main.home.quiz_mode.usecase.GetQuizModeUseCase
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
    fun provideGetModesUseCase(
        repository: RemoteRepository,
        mapper: QuizModeMapper,
    ) = GetQuizModeUseCase(repository, mapper)

    @Provides
    @Singleton
    fun provideQuizModeMapper() = QuizModeMapper()
}
