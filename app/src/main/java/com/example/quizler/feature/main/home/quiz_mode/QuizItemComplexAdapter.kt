package com.example.quizler.feature.main.home.quiz_mode

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizler.databinding.ListItemQuizComplexBinding
import com.example.quizler.domain.data.local.entity.BaseQuizModeEntity
import com.example.quizler.domain.model.QuizMode

class QuizItemComplexAdapter(
    private val list: List<BaseQuizModeEntity>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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
        fun bind(item: BaseQuizModeEntity) {
            binding.item = item
        }
    }
}
