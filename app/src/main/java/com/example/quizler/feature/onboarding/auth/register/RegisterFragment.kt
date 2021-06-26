package com.example.quizler.feature.onboarding.auth.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.quizler.R
import com.example.quizler.databinding.RegisterFragmentBinding
import com.example.quizler.feature.main.MainActivity
import com.example.quizler.util.State
import com.example.quizler.util.extensions.isValidAndPopulated
import com.example.quizler.util.extensions.snack
import com.example.quizler.util.extensions.validated
import com.example.quizler.util.extensions.visibleOrGone
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private val viewModel: RegisterViewModel by viewModels()
    private var _binding: RegisterFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RegisterFragmentBinding.inflate(inflater, container, false)

        initBinding()
        observeRegisterForm()
        initOnClickListeners()

        return binding.root
    }

    private fun initBinding() {
        binding.viewModel = viewModel
    }

    private fun observeRegisterForm() {
        viewModel.bindingModel.observe(
            viewLifecycleOwner,
            {
                with(binding) {
                    btnRegister.isEnabled = isValidAndPopulated(etEmail, etPassword, etUsername)

                    etEmail.validated(it.isEmailValid, R.string.error_email_invalid)
                    etUsername.validated(it.isUsernameValid, R.string.error_username)
                    etPassword.validated(it.isPasswordValid, R.string.error_password)
                }
            }
        )
    }

    private fun gotoMainActivity() {
        binding.progressBar.visibleOrGone(false)
        val intent = MainActivity.newInstance(requireContext())
        startActivity(intent)
    }

    private fun initOnClickListeners() {
        binding.btnLogin.setOnClickListener {
            gotoLogin()
        }
    }

    private fun gotoLogin() {
        val direction = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
        findNavController().navigate(direction)
    }

    override fun onResume() {
        super.onResume()

        observeRegister()
    }

    private fun observeRegister() {
        viewModel.registerState.observe(
            viewLifecycleOwner,
            {
                when (it) {
                    is State.Error -> showError(it.messageResId)
                    is State.Loading -> binding.progressBar.visibleOrGone(true)
                    is State.Success -> gotoMainActivity()
                }
            }
        )
    }

    private fun showError(messageResId: Int?) {
        binding.progressBar.visibleOrGone(false)
        requireView().snack(messageResId)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
