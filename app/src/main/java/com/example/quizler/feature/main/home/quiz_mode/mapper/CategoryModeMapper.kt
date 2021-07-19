package com.example.quizler.feature.main.home.quiz_mode.mapper

import com.example.quizler.domain.data.local.entity.CategoryModeEntity
import com.example.quizler.domain.model.CategoryModeDto
import com.example.quizler.util.extensions.capitalizeAndJoin
import com.example.quizler.util.mapper.DataMapper

private const val TITLE_PREFIX = "mode_title_"
private const val DESCRIPTION_PREFIX = "mode_description_"
private const val ICON_PREFIX = "ic_mode_"
private const val BACKGROUND_COLOR_PREFIX = "color"

class CategoryModeMapper : DataMapper<CategoryModeDto, CategoryModeEntity> {
    override fun map(input: CategoryModeDto): CategoryModeEntity {
        val a =  CategoryModeEntity(
            id = input.id,
            name = input.name,
            titleResName = TITLE_PREFIX.plus(input.name.lowercase().replace(" ", "_")),
            descriptionResName = DESCRIPTION_PREFIX.plus(input.name.lowercase().replace(" ", "_")),
            modeIconSrc = ICON_PREFIX.plus(input.name.lowercase()),
            modeIconBackgroundColor = BACKGROUND_COLOR_PREFIX.plus(input.name.capitalizeAndJoin()),
            numberOfQuestions = input.numberOfQuestions,
            numberOfHints = input.numberOfHints,
            timePerQuestion = input.timePerQuestion
        )
        return a
    }
}
