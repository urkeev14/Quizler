package com.example.quizler.feature.main.home

import androidx.lifecycle.ViewModel
import com.example.quizler.feature.main.home.quiz_mode.QuizModeScreenDirectionResolver
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val directionResolver: QuizModeScreenDirectionResolver
) : ViewModel() {

    fun getDirection(position: Int): Int = directionResolver.getDirection(position)
}
