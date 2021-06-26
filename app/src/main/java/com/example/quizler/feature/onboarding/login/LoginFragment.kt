package com.example.quizler.feature.onboarding.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.quizler.R
import com.example.quizler.databinding.LoginFragmentBinding
import com.example.quizler.feature.main.MainActivity
import com.example.quizler.util.State
import com.example.quizler.util.extensions.isValidAndPopulated
import com.example.quizler.util.extensions.snack
import com.example.quizler.util.extensions.validated
import com.example.quizler.util.extensions.visibleOrGone
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: LoginFragmentBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel

        initOnClickListeners()
        observeLoginFormPopulation()

        return binding.root
    }

    private fun observeLoginFormPopulation() {
        viewModel.bindingModel.observe(viewLifecycleOwner, {
            with(binding) {
                etUsername.validated(it.isUsernameValid, R.string.error_username_login)
                etPassword.validated(it.isPasswordValid, R.string.error_password)

                btnLogin.isEnabled = it.isPasswordValid && it.isUsernameValid
            }
        })
    }

    private fun initOnClickListeners() {
        binding.btnRegister.setOnClickListener {
            gotoRegisterFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLoginResult()
    }

    private fun observeLoginResult() {
        viewModel.loginState.observe(
            viewLifecycleOwner,
            { result ->
                when (result) {
                    is State.Loading -> binding.progressBar.visibleOrGone(true)
                    is State.Success -> gotoMainActivity()
                    is State.Error -> showError()
                }
            }
        )
    }

    private fun showError() {
        binding.progressBar.visibleOrGone(false)
        requireView().snack(R.string.error_login)
    }

    private fun gotoMainActivity() {
        binding.progressBar.visibleOrGone(false)
        startActivity(MainActivity.newInstance(requireContext()))
    }

    private fun gotoRegisterFragment() {
        val direction = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
        findNavController().navigate(direction)
    }
}
