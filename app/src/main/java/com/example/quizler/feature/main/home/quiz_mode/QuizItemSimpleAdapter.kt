package com.example.quizler.feature.main.home.quiz_mode

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizler.databinding.ListItemQuizSimpleBinding
import com.example.quizler.domain.model.QuizMode

class QuizItemSimpleAdapter(
    private val list: List<QuizMode>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ListItemQuizSimpleBinding.inflate(LayoutInflater.from(parent.context))
        return QuizItemSimpleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]
        val binding = (holder as QuizItemSimpleViewHolder)
        binding.bind(item)
    }

    override fun getItemCount(): Int = list.size

    class QuizItemSimpleViewHolder(var binding: ListItemQuizSimpleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: QuizMode) {
            binding.item = item
        }
    }
}