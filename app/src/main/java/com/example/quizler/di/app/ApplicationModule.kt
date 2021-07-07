package com.example.quizler.di.app

import com.example.quizler.domain.data.local.LocalRepository
import com.example.quizler.domain.data.remote.RemoteRepository
import com.example.quizler.feature.main.home.quiz_mode.QuizModeMapper
import com.example.quizler.feature.main.home.quiz_mode.QuizModeMockDataProvider
import com.example.quizler.feature.main.home.quiz_mode.usecase.GetQuizModeUseCase
import com.example.quizler.feature.onboarding.login.LoginUseCase
import com.example.quizler.feature.onboarding.register.RegisterPlayerUserCaseMapper
import com.example.quizler.feature.onboarding.register.RegisterResponseHandler
import com.example.quizler.feature.onboarding.register.RegisterUseCase
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
        dataProvider: QuizModeMockDataProvider
    ) = GetQuizModeUseCase(repository, mapper, dataProvider)

    @Provides
    @Singleton
    fun provideQuizModeMockDataProvider() = QuizModeMockDataProvider()

    @Provides
    @Singleton
    fun provideQuizModeMapper() = QuizModeMapper()
}
