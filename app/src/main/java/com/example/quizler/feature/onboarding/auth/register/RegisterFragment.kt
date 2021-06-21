package com.example.quizler.feature.onboarding.auth.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.quizler.R
import com.example.quizler.databinding.RegisterFragmentBinding
import com.example.quizler.feature.main.MainActivity
import com.example.quizler.util.extensions.containsNoError
import com.example.quizler.util.extensions.validated
import com.example.quizler.util.extensions.visibleOrGone
import com.google.android.material.snackbar.Snackbar
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
        observeRegisterFormPopulation()
        initOnClickListeners()

        return binding.root
    }

    private fun initBinding() {
        binding.viewModel = viewModel
    }

    private fun observeRegisterFormPopulation() {
        viewModel.bindingModel.observe(
            viewLifecycleOwner,
            {
                with(binding) {
                    btnRegister.isEnabled = containsNoError(etEmail, etPassword, etUsername)

                    etEmail.validated(it.isEmailValid, R.string.error_email_invalid)
                    etUsername.validated(it.isUsernameValid, R.string.error_username)
                    etPassword.validated(it.isPasswordValid, R.string.error_password)

                    progressBar.visibleOrGone(it.isLoading)

                    if (it.isRegisterSuccess) gotoMainActivity()

                    it.errorMessage.getContentIfNotHandled() { messageResId: Int? ->
                        requireView().snack(messageResId)
                    }
                }
            }
        )
    }

    private fun gotoMainActivity() {
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
}

fun View.snack(@StringRes stringRes: Int?) {
    if (stringRes != null) {
        Snackbar.make(this, stringRes, Snackbar.LENGTH_LONG).show()
    }
}
