package com.example.quizler.util.extensions

import java.util.Locale

/**
 * Extension function that capitalizes every word in a string, after which
 * removes blank characters
 */
fun String.capitalizeAndJoin(): String {
    return this.split(" ").joinToString("") { word ->
        word.replaceFirstChar { it.uppercaseChar() }
    }

}