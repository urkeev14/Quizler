package com.example.quizler.feature.onboarding.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizler.domain.data.remote.request.RegisterRequestBody
import com.example.quizler.feature.onboarding.AuthFormValidationUseCase
import com.example.quizler.util.SingleLiveEvent
import com.example.quizler.util.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    val form: RegisterForm,
    private val _bindingModel: MutableLiveData<RegisterBindingModel>,
    private val formValidationUseCase: AuthFormValidationUseCase,
    private val registerPlayerUseCase: RegisterUseCase,
    val registerState: SingleLiveEvent<State<Boolean>>
) : ViewModel() {

    val bindingModel: LiveData<RegisterBindingModel> = _bindingModel

    fun onUsernameChanged() {
        val isValid = formValidationUseCase.validateUsernameForRegister(form.username)
        setIsUsernameValid(isValid)
    }

    fun onEmailChanged() {
        val isValid = formValidationUseCase.validateEmail(form.email)
        setIsEmailValid(isValid)
    }

    fun onPasswordChanged() {
        val isValid = formValidationUseCase.validatePasswordForRegister(form.password)
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

    fun register() {
        viewModelScope.launch {
            registerState.postValue(State.Loading())

            delay(1500)
            val state = registerPlayerUseCase.register(getRequestBody())

            registerState.postValue(state)
        }
    }

    private fun getRequestBody() = RegisterRequestBody(form.username, form.email, form.password)
}
