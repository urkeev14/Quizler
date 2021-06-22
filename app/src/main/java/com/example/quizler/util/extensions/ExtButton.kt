package com.example.quizler.util.extensions

import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

fun Button.enableIfNoError(vararg list: TextInputEditText): Boolean = list.all { field ->
    field.error == null && field.text.isNullOrEmpty().not()
}
