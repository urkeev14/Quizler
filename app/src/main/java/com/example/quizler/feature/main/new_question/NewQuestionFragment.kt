package com.example.quizler.feature.main.new_question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.quizler.R
import com.example.quizler.databinding.FragmentNewQuestionBinding
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

        val items = listOf("Opsta informisanost", "Sport", "Muzika", "Film", "Istorija", "Geografija").sortedBy { it.first() }
        val adapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item, items)
        binding.dropdownCategory.setAdapter(adapter)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

}
