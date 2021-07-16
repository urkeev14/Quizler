package com.example.quizler.feature.main.new_question

data class NewQuestionBindingModel(
    var question: String = "",
    var categoryId: String = "",
    var answerA: String = "",
    var answerB: String = "",
    var answerC: String = "",
    var answerD: String = "",
    var isAnswerACorrect: Boolean = true,
    var isAnswerBCorrect: Boolean = false,
    var isAnswerCCorrect: Boolean = false,
    var isAnswerDCorrect: Boolean = false,
)
