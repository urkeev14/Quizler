package com.example.quizler.feature.main.home.quiz_mode.cateogry

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.quizler.di.viewmodel.DifficultyQuizModeListState
import com.example.quizler.domain.model.QuizMode
import com.example.quizler.feature.main.home.quiz_mode.usecase.GetModesCategoryUseCase
import com.example.quizler.util.State
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoryModeViewModel
@Inject constructor(
    private val useCase: GetModesCategoryUseCase
) : ViewModel() {

    fun getData() = useCase.fetch().asLiveData()
}
