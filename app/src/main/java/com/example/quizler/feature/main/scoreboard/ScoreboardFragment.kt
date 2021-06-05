package com.example.quizler.feature.main.scoreboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.quizler.R

class ScoreboardFragment : Fragment() {

    companion object {
        fun newInstance() = ScoreboardFragment()
    }

    private lateinit var viewModel: ScoreboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.scoreboard_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ScoreboardViewModel::class.java)
        // TODO: Use the ViewModel
    }
}
