package com.example.quizler.feature.main.home.quiz_mode.length

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizler.R
import com.example.quizler.databinding.LengthModeFragmentBinding
import com.example.quizler.domain.model.QuizMode
import com.example.quizler.feature.main.home.quiz_mode.QuizItemComplexAdapter
import com.example.quizler.feature.main.home.quiz_mode.QuizItemComplexItemDecorator
import com.example.quizler.util.State
import com.example.quizler.util.extensions.snack
import com.example.quizler.util.extensions.visibleOrGone
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LengthModeFragment : Fragment() {

    private val viewModel: LengthModeViewModel by viewModels()
    private var _binding: LengthModeFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = LengthModeFragmentBinding.inflate(inflater, container, false)
        observeData()
        return binding.root
    }

    private fun observeData() {
        viewModel.data.observe(
            viewLifecycleOwner,
            { state ->
                when (state) {
                    is State.Loading -> showProgressBar(false)
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

    private fun populateRecyclerView(data: List<QuizMode>?) {
        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = QuizItemComplexAdapter(data ?: emptyList())
            addItemDecoration(QuizItemComplexItemDecorator(resources.getInteger(R.integer.decorator_margin_small)))
        }
    }

    private fun showProgressBar(isVisible: Boolean) {
        binding.progressBar.visibleOrGone(isVisible)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
