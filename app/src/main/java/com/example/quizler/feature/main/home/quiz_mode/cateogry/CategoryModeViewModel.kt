package com.example.quizler.feature.main.home.quiz_mode.cateogry

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizler.di.viewmodel.DifficultyQuizModeListState
import com.example.quizler.domain.model.QuizMode
import com.example.quizler.feature.main.home.quiz_mode.usecase.GetQuizModeUseCase
import com.example.quizler.util.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryModeViewModel
@Inject constructor(
    @DifficultyQuizModeListState
    private val _data: MutableLiveData<State<List<QuizMode>>>,
    private val useCase: GetQuizModeUseCase
) : ViewModel() {

    val data = _data as LiveData<State<List<QuizMode>>>

    init {
        getModes()
    }

    private fun getModes() = viewModelScope.launch(Dispatchers.IO) {
        _data.postValue(State.Loading())
        _data.postValue(useCase.getCategoryModes())
    }
}
