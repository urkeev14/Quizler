package com.example.quizler.util.databinding

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.quizler.util.extensions.capitalizeAndJoin
import com.example.quizler.util.extensions.getColorResId
import com.example.quizler.util.extensions.getDrawableResIdByName
import com.example.quizler.util.extensions.getStringByResIdName

@BindingAdapter("resourceIdPrefix", "resourceIdPostfix")
fun TextView.textFromStringResourceIdName(resIdPrefix: String, resIdPostfix: String) {
    val title = this.getStringByResIdName("$resIdPrefix$resIdPostfix")
    this.setText(title)
}

/**
 * Sets a drawable source to [ImageView] based on [resourceName]
 */
@BindingAdapter(value = ["srcPrefix", "srcSufix"], requireAll = true)
fun ImageView.setSource(prefix: String, sufix: String) {
    val modeLogo = this.getDrawableResIdByName("$prefix$sufix")
    this.setImageDrawable(modeLogo)
}

@BindingAdapter("colorResIdName")
fun ImageView.backgroundFromColorRes(value: String) {
    val itemNameCapitalized = value.capitalizeAndJoin()
    val modeBackgroundColor = this.getColorResId("color$itemNameCapitalized")
    this.setBackgroundResource(modeBackgroundColor)
    this.refreshDrawableState()
}