package com.example.quizler.feature.main.home.quiz_mode.difficulty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizler.R
import com.example.quizler.databinding.FragmentDifficultyModeBinding
import com.example.quizler.domain.data.local.entity.BaseQuizModeEntity
import com.example.quizler.domain.model.QuizMode
import com.example.quizler.feature.main.home.quiz_mode.QuizItemComplexAdapter
import com.example.quizler.feature.main.home.quiz_mode.QuizItemComplexItemDecorator
import com.example.quizler.util.State
import com.example.quizler.util.extensions.goneUnless
import com.example.quizler.util.extensions.snack
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DifficultyModeFragment : Fragment() {

    private val viewModel: DifficultyModeViewModel by viewModels()
    private var _binding: FragmentDifficultyModeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDifficultyModeBinding.inflate(inflater, container, false)
        observeData()
        return binding.root
    }

    private fun observeData() {
        viewModel.getData().observe(
            viewLifecycleOwner,
            { state ->
                populateRecyclerView(state.data)
                binding.progressBar.goneUnless(state is State.Loading && state.data.isNullOrEmpty())
            }
        )
    }

    private fun populateRecyclerView(data: List<BaseQuizModeEntity>?) {
        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = QuizItemComplexAdapter(data ?: emptyList())
            addItemDecoration(QuizItemComplexItemDecorator(resources.getInteger(R.integer.decorator_margin_normal)))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
