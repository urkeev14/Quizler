package com.example.quizler.feature.main.home.quiz_mode.length

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizler.di.LengthQuizModeListState
import com.example.quizler.domain.model.QuizMode
import com.example.quizler.feature.main.home.quiz_mode.usecase.GetQuizModeUseCase
import com.example.quizler.util.State
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

@HiltViewModel
class LengthModeViewModel
@Inject constructor(
    @LengthQuizModeListState
    private val _data: MutableLiveData<State<List<QuizMode>>>,
    private val useCase: GetQuizModeUseCase,
) : ViewModel() {

    val data = _data as LiveData<State<List<QuizMode>>>

    init {
        getModes()
    }

    private fun getModes() = viewModelScope.launch(IO) {
        _data.postValue(useCase.getModes("duzina"))
    }
}
