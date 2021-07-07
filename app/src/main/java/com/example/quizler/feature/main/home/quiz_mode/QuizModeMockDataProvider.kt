package com.example.quizler.feature.main.home.quiz_mode

import com.example.quizler.domain.model.QuizModeDto

class QuizModeMockDataProvider {

    private val listDifficulty: List<QuizModeDto> = mutableListOf(
        QuizModeDto(
            id = "111",
            name = "easy",
            timePerQuestion = 30,
            numberOfHints = 3,
            numberOfQuestions = 20
        ),
        QuizModeDto(
            id = "111",
            name = "average",
            timePerQuestion = 30,
            numberOfHints = 3,
            numberOfQuestions = 20
        ),
        QuizModeDto(
            id = "111",
            name = "hard",
            timePerQuestion = 30,
            numberOfHints = 3,
            numberOfQuestions = 20
        )
    )

    private val listLength: List<QuizModeDto> = mutableListOf(
        QuizModeDto(
            id = "111",
            name = "zen",
            timePerQuestion = 30,
            numberOfHints = 3,
            numberOfQuestions = 20
        ),
        QuizModeDto(
            id = "111",
            name = "exam",
            timePerQuestion = 30,
            numberOfHints = 3,
            numberOfQuestions = 20
        ),
        QuizModeDto(
            id = "111",
            name = "marathon",
            timePerQuestion = 30,
            numberOfHints = 3,
            numberOfQuestions = 20
        )
    )

    private val listCategory: List<QuizModeDto> = mutableListOf(
        QuizModeDto(
            id = "111",
            name = "geography",
            timePerQuestion = 30,
            numberOfHints = 3,
            numberOfQuestions = 20
        ),
        QuizModeDto(
            id = "111",
            name = "history",
            timePerQuestion = 30,
            numberOfHints = 3,
            numberOfQuestions = 20
        ),
        QuizModeDto(
            id = "111",
            name = "movie",
            timePerQuestion = 30,
            numberOfHints = 3,
            numberOfQuestions = 20
        ),
        QuizModeDto(
            id = "111",
            name = "music",
            timePerQuestion = 30,
            numberOfHints = 3,
            numberOfQuestions = 20
        ),
        QuizModeDto(
            id = "111",
            name = "general knowledge",
            timePerQuestion = 30,
            numberOfHints = 3,
            numberOfQuestions = 20
        ),
        QuizModeDto(
            id = "111",
            name = "sport",
            timePerQuestion = 30,
            numberOfHints = 3,
            numberOfQuestions = 20
        )
    )

    val mockedModes = mapOf(
        "tezina" to listDifficulty,
        "duzina" to listLength,
        "category" to listCategory
    )
}
