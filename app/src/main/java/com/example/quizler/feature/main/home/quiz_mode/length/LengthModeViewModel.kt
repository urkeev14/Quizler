package com.example.quizler.feature.main.home.quiz_mode.length

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.quizler.feature.main.home.quiz_mode.usecase.GetModesLengthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LengthModeViewModel
@Inject constructor(
    private val useCase: GetModesLengthUseCase,
) : ViewModel() {

    fun getData() = useCase.fetch().asLiveData()

}
