package com.example.quizler.domain.model

/**
 * Represents an item in [QuizItemComplexAdapter] class
 */
data class QuizModeDto(
    val id: String,
    val name: String,
    val numberOfHints: Int,
    val numberOfQuestions: Int,
    val timePerQuestion: Int,
)
