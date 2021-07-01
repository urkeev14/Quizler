package com.example.quizler.feature.main.home.quiz_mode

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class QuizItemComplexItemDecorator(
    private val spacing: Int = 16,
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view) // item position

        outRect.apply {
            if (position == 0) {
                top = spacing
            }
            left = spacing
            right = spacing
            bottom = spacing
        }
    }

}