package com.example.quizler.domain.data.local.entity

import androidx.room.Entity

@Entity(tableName = "length", primaryKeys = ["id", "name"])
class LengthModeEntity(
    id: String,
    name: String,
    titleResName: String,
    descriptionResName: String,
    modeIconSrc: String,
    modeIconBackgroundColor: String,
    numberOfHints: Int,
    numberOfQuestions: Int,
    timePerQuestion: Int,
) : BaseQuizModeEntity(
    id,
    name,
    titleResName,
    descriptionResName,
    modeIconSrc,
    modeIconBackgroundColor,
    numberOfHints,
    numberOfQuestions,
    timePerQuestion
)
