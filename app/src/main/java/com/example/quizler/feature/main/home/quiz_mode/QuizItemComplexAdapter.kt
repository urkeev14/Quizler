package com.example.quizler.feature.main.home.quiz_mode

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizler.databinding.ListItemQuizComplexBinding
import com.example.quizler.domain.model.QuizModeItem

class QuizItemComplexAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list: MutableList<QuizModeItem> = mutableListOf(
        QuizModeItem(
            id = "111",
            name = "zen",
            timePerQuestion = 30,
            numberOfHints = 3,
            numberOfQuestions = 20
        ),
        QuizModeItem(
            id = "111",
            name = "test",
            timePerQuestion = 30,
            numberOfHints = 3,
            numberOfQuestions = 20
        ),
        QuizModeItem(
            id = "111",
            name = "maraton",
            timePerQuestion = 30,
            numberOfHints = 3,
            numberOfQuestions = 20
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ListItemQuizComplexBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuizItemComplexViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]
        val binding = (holder as QuizItemComplexViewHolder)
        binding.bind(item)
    }

    override fun getItemCount(): Int = list.size

    class QuizItemComplexViewHolder(var binding: ListItemQuizComplexBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: QuizModeItem) {
            binding.item = item
        }
    }
}
