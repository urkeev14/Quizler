package com.example.quizler.util.databinding

import android.widget.RadioButton
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener

@BindingAdapter("android:bindOnChecked")
fun RadioButton.setOnChecked(value: Boolean) {
    this.isChecked = value
}

@InverseBindingAdapter(attribute = "android:bindOnChecked")
fun RadioButton.getOnChecked(): Boolean {
    return this.isChecked
}

@BindingAdapter("android:bindOnCheckedAttrChanged")
fun RadioButton.setListeners(attrChange: InverseBindingListener?) {
    this.setOnCheckedChangeListener { buttonView, isChecked ->
        attrChange?.onChange()
    }
}
