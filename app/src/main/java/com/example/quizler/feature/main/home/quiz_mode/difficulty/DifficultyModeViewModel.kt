package com.example.quizler.feature.main.home.quiz_mode.difficulty

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.quizler.feature.main.home.quiz_mode.usecase.GetModesDifficultyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DifficultyModeViewModel
@Inject constructor(
    private val useCase: GetModesDifficultyUseCase
) : ViewModel() {

    fun getData() = useCase.fetch().asLiveData()
}
