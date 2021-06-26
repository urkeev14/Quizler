package com.example.quizler.feature.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.quizler.databinding.HomeFragmentBinding
import com.example.quizler.util.extensions.onTabSelected
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    private val navController by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)

        initNavigation()

        return binding.root
    }

    private fun initNavigation() {
        binding.tabLayout.onTabSelected { position ->
            navigateByTab(position)
        }
    }

    private fun navigateByTab(position: Int) {
        val direction = viewModel.getDirection(position)
        navController.navigate(direction)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
