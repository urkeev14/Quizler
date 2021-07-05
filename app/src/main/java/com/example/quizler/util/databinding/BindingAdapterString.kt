package com.example.quizler.util.databinding

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.quizler.util.extensions.getColorResId
import com.example.quizler.util.extensions.getDrawableResIdByName
import com.example.quizler.util.extensions.getStringByResIdName

@BindingAdapter("textFromResName")
fun TextView.textFromStringResourceIdName(value: String) {
    try {
        val title = this.getStringByResIdName(value)
        this.setText(title)
    } catch (e: Exception) {
        Log.e("ADAPTER ERROR", "textFromResName: No resource found with name $value")
    }
}

/**
 * Sets a drawable source to [ImageView] based on [resourceName]
 */
@BindingAdapter("drawableFromResName")
fun ImageView.setSource(resourceName: String) {
    try {
        val modeLogo = this.getDrawableResIdByName(resourceName)
        this.setImageDrawable(modeLogo)
    } catch (e: Exception) {
        Log.e("ADAPTER ERROR", "drawableFromResName: No resource found with name $resourceName")
    }
}

@BindingAdapter("backgroundFromColorRes")
fun ImageView.backgroundFromColorRes(value: String) {
    try {
        val modeBackgroundColor = this.getColorResId(value)
        this.setBackgroundResource(modeBackgroundColor)
        this.refreshDrawableState()
    } catch (e: Exception) {
        Log.e("ADAPTER ERROR", "setSource: No resource found with name $value")
    }
}
