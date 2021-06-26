package com.example.quizler.feature.main.home.quiz_mode.cateogry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.quizler.R

class CategoryModeFragment : Fragment() {

    companion object {
        fun newInstance() = CategoryModeFragment()
    }

    private lateinit var viewModel: CategoryModeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.category_mode_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CategoryModeViewModel::class.java)
        // TODO: Use the ViewModel
    }
}
