package com.example.quizler.util.extensions

import androidx.annotation.StringRes
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

/**
 * Extension function that shows an error in [TextInputEditText] if
 * it's text is not empty and the input is invalid.
 */
fun TextInputEditText.validated(isValid: Boolean, @StringRes errorResId: Int) {
    val container = parent.parent as TextInputLayout

    if (text!!.isNotEmpty() && isValid.not()) {
        if (container.error == null) {
            container.isErrorEnabled = true
            container.error = context.getString(errorResId)
        }
    } else {
        container.isErrorEnabled = false
        container.error = null
    }
}

/**
 * Extension function that checks if a list of [TextInputEditText]
 * @return [true] if no instance of list contains error, else [false]
 */
fun containsNoError(vararg list: TextInputEditText): Boolean = list.all { field ->
    field.error == null && field.text.isNullOrEmpty().not()
}
