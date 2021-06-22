package com.example.quizler.util.extensions

import android.view.View
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar

/**
 * Extension function that changes visibility of a [View] to [View.VISIBLE]
 * if parameter [isVisible] equals true. Otherwise, sets [View]'s visibility
 * to [View.GONE]
 */
fun View.visibleOrGone(isVisible: Boolean) {
    this.visibility = if (isVisible) View.VISIBLE else View.GONE
}

/**
 * Extension function that changes visibility of a [View] to [View.VISIBLE]
 * if parameter [isVisible] equals true. Otherwise, sets [View]'s visibility
 * to [View.INVISIBLE]
 */
fun View.visibleOrInvisible(isVisible: Boolean) {
    this.visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
}

/**
 * Show a snackbar if parameter [stringRes] is not null
 */
fun View.snack(@StringRes stringRes: Int?) {
    if (stringRes != null) {
        Snackbar.make(this, stringRes, Snackbar.LENGTH_LONG).show()
    }
}
