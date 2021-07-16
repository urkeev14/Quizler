package com.example.quizler.feature.main.new_question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.quizler.R
import com.example.quizler.databinding.FragmentNewQuestionBinding
import com.example.quizler.domain.model.QuizMode
import com.example.quizler.util.State
import com.example.quizler.util.extensions.goneUnless
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewQuestionFragment : Fragment() {

    private val viewModel by viewModels<NewQuestionViewModel>()
    private var _binding: FragmentNewQuestionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewQuestionBinding.inflate(inflater, container, false)

        bindData()
        observeData()

        return binding.root
    }

    private fun bindData() {
        binding.model = viewModel.bindingModel
        binding.listener = viewModel
    }

    private fun observeData() {
        viewModel.categories.observe(
            viewLifecycleOwner,
            { state ->
                when (state) {
                    is State.Error -> handleError(state)
                    is State.Loading -> handleLoading()
                    is State.Success -> handleSuccess(state)
                }
            }
        )
    }

    private fun handleSuccess(state: State.Success<List<QuizMode>>) {
        binding.progressBar.goneUnless(false)
        val items = state.data!!.sortedBy { it.name }.map { it.name }
        val adapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item, items)
        binding.dropdownCategory.setAdapter(adapter)
    }

    private fun handleLoading() {
        binding.progressBar.goneUnless(true)
    }

    private fun handleError(state: State.Error<List<QuizMode>>) {
        binding.progressBar.goneUnless(false)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
