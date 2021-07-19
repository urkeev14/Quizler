package com.example.quizler.domain.model

import com.google.gson.annotations.SerializedName

data class DifficultyModeDto(
    @SerializedName("_id") val id: String,
    val name: String,
    val numberOfHints: Int = 3,
    val numberOfQuestions: Int = 20,
    val timePerQuestion: Int = 15,
)
