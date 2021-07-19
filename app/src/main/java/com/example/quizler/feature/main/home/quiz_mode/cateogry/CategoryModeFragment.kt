package com.example.quizler.feature.main.home.quiz_mode.cateogry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.quizler.R
import com.example.quizler.databinding.FragmentCategoryModeBinding
import com.example.quizler.domain.data.local.entity.BaseQuizModeEntity
import com.example.quizler.feature.main.home.quiz_mode.QuizItemSimpleAdapter
import com.example.quizler.feature.main.home.quiz_mode.QuizItemSimpleItemDecorator
import com.example.quizler.util.State
import com.example.quizler.util.extensions.goneUnless
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryModeFragment : Fragment() {

    private val viewModel: CategoryModeViewModel by viewModels()
    private var _binding: FragmentCategoryModeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCategoryModeBinding.inflate(inflater, container, false)
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
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            addItemDecoration(QuizItemSimpleItemDecorator(2, resources.getInteger(R.integer.decorator_margin_normal), true))
            adapter = QuizItemSimpleAdapter(data ?: emptyList())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
