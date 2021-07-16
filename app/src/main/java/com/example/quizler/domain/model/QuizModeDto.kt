package com.example.quizler.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Represents an item in [QuizItemComplexAdapter] class
 */
// TODO: MAPIRAJ VREDNOSTI
data class QuizModeDto(
    @SerializedName("_id") val id: String,
    val name: String,
    val numberOfHints: Int = 3,
    val numberOfQuestions: Int = 20,
    val timePerQuestion: Int = 15,
)
