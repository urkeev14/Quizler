package com.example.quizler.domain.model

data class QuizMode(
    val id: String,
    val name: String,
    val titleResName: String,
    val descriptionResName: String,
    val modeIconSrc: String,
    val modeIconBackgroundColor: String,
    val numberOfHints: Int,
    val numberOfQuestions: Int,
    val timePerQuestion: Int,
)
