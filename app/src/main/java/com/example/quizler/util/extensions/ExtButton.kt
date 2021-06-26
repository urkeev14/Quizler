package com.example.quizler.util.extensions

import com.google.android.material.textfield.TextInputEditText

fun isValidAndPopulated(vararg list: TextInputEditText): Boolean = list.all { field ->
    field.error == null && field.text!!.isNotEmpty()
}
