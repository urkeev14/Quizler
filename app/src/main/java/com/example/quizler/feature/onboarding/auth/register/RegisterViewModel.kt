package com.example.quizler.feature.onboarding.auth.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizler.R
import com.example.quizler.domain.model.RegisterForm
import com.example.quizler.feature.onboarding.auth.usecase.AuthFormValidationUseCase
import com.example.quizler.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class RegisterViewModel @Inject constructor(
    val form: RegisterForm,
    private val _bindingModel: MutableLiveData<RegisterBindingModel>,
    private val formValidationUseCase: AuthFormValidationUseCase,
    private val registerPlayerUseCase: RegisterUseCase
) : ViewModel() {

    val bindingModel: LiveData<RegisterBindingModel> = _bindingModel

    fun onUsernameChanged() {
        val isValid = formValidationUseCase.validateUsername(form.username)
        setIsUsernameValid(isValid)
    }

    fun onEmailChanged() {
        val isValid = formValidationUseCase.validateEmail(form.email)
        setIsEmailValid(isValid)
    }

    fun onPasswordChanged() {
        val isValid = formValidationUseCase.validatePassword(form.password)
        setIsPasswordValid(isValid)
    }

    private fun setIsUsernameValid(isValid: Boolean) {
        _bindingModel.postValue(
            _bindingModel.value!!.copy(
                isUsernameValid = isValid
            )
        )
    }

    private fun setIsEmailValid(isValid: Boolean) {
        _bindingModel.postValue(
            _bindingModel.value!!.copy(
                isEmailValid = isValid
            )
        )
    }

    private fun setIsPasswordValid(isValid: Boolean) {
        _bindingModel.postValue(
            _bindingModel.value!!.copy(
                isPasswordValid = isValid
            )
        )
    }

    // FIXME: Uncomment network call for register when implemented
    fun register() {
        viewModelScope.launch {
            setRegisterExecuted()
            delay(2000)

            val outcome = RegisterOutcome(false, R.string.error_email_exist)
//            val outcome = registerPlayerUseCase.register(Player(null, form.username, form.email, form.password))

            setRegisterOutcome(outcome)
        }
    }

    private fun setRegisterExecuted() {
        _bindingModel.postValue(
            _bindingModel.value!!.copy(
                isLoading = true,
            )
        )
    }

    private fun setRegisterOutcome(outcome: RegisterOutcome) {
        _bindingModel.postValue(
            _bindingModel.value!!.copy(
                isLoading = false,
                isRegisterSuccess = outcome.isSuccessful,
                errorMessage = Event(outcome.errorResId)
            )
        )
    }
}
