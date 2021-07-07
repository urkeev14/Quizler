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
annotation class LengthQuizModeListState

@Module
@InstallIn(ViewModelComponent::class)
object LengthViewModelModule {

    @LengthQuizModeListState
    @Provides
    fun provideLengthQuizModeListState() = MutableLiveData<State<List<QuizMode>>>(State.Loading())
}