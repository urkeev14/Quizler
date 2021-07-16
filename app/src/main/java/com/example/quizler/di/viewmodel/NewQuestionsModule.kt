package com.example.quizler.di.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.quizler.domain.model.QuizMode
import com.example.quizler.feature.main.new_question.NewQuestionBindingModel
import com.example.quizler.util.State
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CategoriesListState

@Module
@InstallIn(ViewModelComponent::class)
object NewQuestionsModule {

    @CategoriesListState
    @Provides
    fun provideCategoriesState(): MutableLiveData<State<List<QuizMode>>> = MutableLiveData(State.Loading())

    @Provides
    fun provideQuestionBiningModel() = NewQuestionBindingModel()
}
