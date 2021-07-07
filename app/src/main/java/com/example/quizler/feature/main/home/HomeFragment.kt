package com.example.quizler.feature.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.quizler.R
import com.example.quizler.databinding.FragmentHomeBinding
import com.example.quizler.util.extensions.onTabSelected
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    private val navHostFragment by lazy { childFragmentManager.findFragmentById(R.id.nav_host_home) as NavHostFragment }
    private val navController by lazy { navHostFragment.navController }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

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
