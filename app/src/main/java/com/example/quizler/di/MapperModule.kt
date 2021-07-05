package com.example.quizler.di

import com.example.quizler.feature.main.home.quiz_mode.QuizModeMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    @Singleton
    fun provideQuizModeMapper() = QuizModeMapper()
}