package com.example.quizler.feature.main.home.quiz_mode.difficulty

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.quizler.di.viewmodel.DifficultyQuizModeListState
import com.example.quizler.domain.model.QuizMode
import com.example.quizler.feature.main.home.quiz_mode.usecase.GetModesDifficultyUseCase
import com.example.quizler.util.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DifficultyModeViewModel
@Inject constructor(
    private val useCase: GetModesDifficultyUseCase
) : ViewModel() {

    fun getData() = useCase.fetch().asLiveData()

}
