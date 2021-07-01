package com.example.quizler.feature.main.home.quiz_mode.length

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizler.R
import com.example.quizler.databinding.LengthModeFragmentBinding
import com.example.quizler.feature.main.home.quiz_mode.QuizItemComplexAdapter
import com.example.quizler.feature.main.home.quiz_mode.QuizItemComplexItemDecorator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LengthModeFragment : Fragment() {

    private val viewModel: LengthModeViewModel by viewModels()
    private var _binding: LengthModeFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LengthModeFragmentBinding.inflate(inflater, container, false)
        initRecyclerView()
        return binding.root
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = QuizItemComplexAdapter()
        binding.recyclerView.addItemDecoration(QuizItemComplexItemDecorator())
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

}
