package com.example.quizler.domain.data.local.entity

open class BaseQuizModeEntity(
    val id: String,
    val name: String,
    val titleResName: String,
    val descriptionResName: String,
    val modeIconSrc: String,
    val modeIconBackgroundColor: String,
    val numberOfHints: Int,
    val numberOfQuestions: Int,
    val timePerQuestion: Int
)
