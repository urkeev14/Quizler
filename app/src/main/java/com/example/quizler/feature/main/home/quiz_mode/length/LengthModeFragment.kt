package com.example.quizler.feature.main.home.quiz_mode.length

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quizler.R

class LengthModeFragment : Fragment() {

    companion object {
        fun newInstance() = LengthModeFragment()
    }

    private lateinit var viewModel: LengthModeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.length_mode_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LengthModeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}