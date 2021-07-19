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
import com.example.quizler.domain.data.local.entity.CategoryModeEntity
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
        viewModel.getCategories().observe(
            viewLifecycleOwner,
            { state ->
                populateDropdown(state.data)
                binding.progressBar.goneUnless(state is State.Loading && state.data.isNullOrEmpty())
            }
        )
    }

    private fun populateDropdown(list: List<CategoryModeEntity>?) {
        val adapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item, list ?: emptyList())
        binding.dropdownCategory.setAdapter(adapter)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
