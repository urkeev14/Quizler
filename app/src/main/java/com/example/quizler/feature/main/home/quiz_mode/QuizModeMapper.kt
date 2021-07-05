package com.example.quizler.feature.main.home.quiz_mode

import com.example.quizler.domain.model.QuizMode
import com.example.quizler.domain.model.QuizModeDto
import com.example.quizler.util.extensions.capitalizeAndJoin
import com.example.quizler.util.mapper.DataMapper

private const val TITLE_PREFIX = "mode_title_"
private const val DESCRIPTION_PREFIX = "mode_description_"
private const val ICON_PREFIX = "ic_mode_"
private const val BACKGROUND_COLOR_PREFIX = "color"

class QuizModeMapper : DataMapper<QuizModeDto, QuizMode> {
    override fun map(input: QuizModeDto): QuizMode {
        return QuizMode(
            id = input.id,
            name = input.name,
            titleResName = TITLE_PREFIX.plus(input.name.replace(" ", "_")),
            descriptionResName = DESCRIPTION_PREFIX.plus(input.name.replace(" ", "_")),
            modeIconSrc = ICON_PREFIX.plus(input.name),
            modeIconBackgroundColor = BACKGROUND_COLOR_PREFIX.plus(input.name.capitalizeAndJoin()),
            numberOfQuestions = input.numberOfQuestions,
            numberOfHints = input.numberOfHints,
            timePerQuestion = input.timePerQuestion
        )
    }
}
