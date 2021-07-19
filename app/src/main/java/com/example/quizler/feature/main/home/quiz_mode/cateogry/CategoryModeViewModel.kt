package com.example.quizler.feature.main.home.quiz_mode.cateogry

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.quizler.feature.main.home.quiz_mode.usecase.GetModesCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoryModeViewModel
@Inject constructor(
    private val useCase: GetModesCategoryUseCase
) : ViewModel() {

    fun getData() = useCase.fetch().asLiveData()
}
