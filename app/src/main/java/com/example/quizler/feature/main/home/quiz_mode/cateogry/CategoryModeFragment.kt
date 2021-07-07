package com.example.quizler.feature.main.home.quiz_mode.cateogry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.quizler.databinding.CategoryModeFragmentBinding
import com.example.quizler.domain.model.QuizMode
import com.example.quizler.feature.main.home.quiz_mode.QuizItemSimpleAdapter
import com.example.quizler.feature.main.home.quiz_mode.QuizItemSimpleItemDecorator
import com.example.quizler.util.State
import com.example.quizler.util.extensions.snack
import com.example.quizler.util.extensions.visibleOrGone
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryModeFragment : Fragment() {

    private val viewModel: CategoryModeViewModel by viewModels()
    private var _binding: CategoryModeFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CategoryModeFragmentBinding.inflate(inflater, container, false)
        observeData()
        return binding.root
    }

    private fun observeData() {
        viewModel.data.observe(
            viewLifecycleOwner,
            { state ->
                when (state) {
                    is State.Loading -> showProgressBar(true)
                    is State.Success -> handleSuccess(state.data)
                    is State.Error -> handleFailure(state.data, state.messageResId)
                }
            }
        )
    }

    private fun handleSuccess(data: List<QuizMode>?) {
        showProgressBar(false)
        populateRecyclerView(data)
    }

    private fun handleFailure(data: List<QuizMode>?, messageResId: Int?) {
        showProgressBar(false)
        populateRecyclerView(data)
        requireView().snack(messageResId)
    }

    private fun showProgressBar(isVisible: Boolean) {
        binding.progressBar.visibleOrGone(isVisible)
    }

    private fun populateRecyclerView(data: List<QuizMode>?) {
        with(binding.recyclerView) {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            addItemDecoration(QuizItemSimpleItemDecorator(2, 16, true))
            adapter = QuizItemSimpleAdapter(data ?: emptyList())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
