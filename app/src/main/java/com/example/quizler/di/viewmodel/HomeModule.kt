package com.example.quizler.di.viewmodel

import com.example.quizler.feature.main.home.quiz_mode.QuizModeScreenDirectionResolver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object HomeModule {

    @Provides
    fun provideQuizModeScreenDirectionResolver() = QuizModeScreenDirectionResolver()
}
