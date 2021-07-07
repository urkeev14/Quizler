package com.example.quizler.feature.main.new_question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.quizler.R

class NewQuestionFragment : Fragment() {

    companion object {
        fun newInstance() = NewQuestionFragment()
    }

    private lateinit var viewModel: NewQuestionViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_new_question, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NewQuestionViewModel::class.java)
        // TODO: Use the ViewModel
    }
}
