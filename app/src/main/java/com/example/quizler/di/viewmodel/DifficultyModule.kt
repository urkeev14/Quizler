package com.example.quizler.di.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.quizler.domain.model.QuizMode
import com.example.quizler.util.State
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DifficultyQuizModeListState

@Module
@InstallIn(ViewModelComponent::class)
object ApplicationModule {

    @DifficultyQuizModeListState
    @Provides
    fun provideDifficultyQuizModeListState() = MutableLiveData<State<List<QuizMode>>>(State.Loading())
}