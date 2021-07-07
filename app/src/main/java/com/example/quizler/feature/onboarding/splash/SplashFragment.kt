package com.example.quizler.feature.onboarding.splash

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.animation.doOnEnd
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.quizler.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding
    private lateinit var viewModel: SplashViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animateLogo()
    }

    private fun animateLogo() {
        ObjectAnimator.ofFloat(binding.ivQuizlerLogo, "alpha", 1f).also {
            it.duration = 3000
            it.doOnEnd {
                val direction = SplashFragmentDirections.actionSplashFragmentToRegisterFragment()
                findNavController().navigate(direction)
            }
        }.start()
    }
}
