package com.example.quizler.feature.main.home.quiz_mode

import com.example.quizler.R

class QuizModeScreenDirectionResolver {

    fun getDirection(position: Int): Int = when (position) {
        TAB_POSITION_LENGTH -> R.id.action_global_lengthModeFragment
        TAB_POSITION_CATEGORY -> R.id.action_global_categoryModeFragment
        TAB_POSITION_DIFFICULTY -> R.id.action_global_difficultyModeFragment
        else -> throw Exception("Tab position related to quiz mode has to be between 1 and 3")
    }

    private companion object {
        const val TAB_POSITION_LENGTH = 0
        const val TAB_POSITION_CATEGORY = 1
        const val TAB_POSITION_DIFFICULTY = 2
    }
}
