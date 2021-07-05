package com.example.quizler.util.extensions

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.example.quizler.R
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

/**
 * Show a snackbar if parameter [stringRes] is not null
 */
fun View.snack(string: String?) = string?.let {
    Snackbar.make(this, string, Snackbar.LENGTH_LONG).show()
}

/**
 * Extension function that returns a resource ID from generated class [R]
 * by the name of that resource
 */
fun View.getDrawableResIdByName(resourceName: String): Drawable {
    val context = this.rootView.context

    val resourceId = rootView.resources!!.getIdentifier(
        resourceName,
        "drawable",
        context.packageName
    )

    return try {
        ContextCompat.getDrawable(context, resourceId)!!
    } catch (e: Exception) {
        Log.d("ERROR", "String with name $resourceName does not exist ")
        ContextCompat.getDrawable(context, R.drawable.ic_brain)!!
    }
}

/**
 * Extension function that returns a resource ID from generated class [R]
 * by the name of that resource
 */
fun View.getColorResId(resourceName: String): Int {
    val context = this.rootView.context

    return rootView.resources!!.getIdentifier(
        resourceName,
        "color",
        context.packageName
    )
}

/**
 * Extension function that returns a [String] value of particular resource ID
 * by the name of that resource
 */
fun View.getStringByResIdName(resourceName: String): Int {
    val context = this.rootView.context

    return try {
        this.rootView.resources!!.getIdentifier(
            resourceName,
            "string",
            context.packageName
        )
    } catch (e: Exception) {
        Log.d("ERROR", "String with name $resourceName does not exist ")
        return 1
    }
}
