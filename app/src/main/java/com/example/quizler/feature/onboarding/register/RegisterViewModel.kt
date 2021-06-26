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
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val REGISTER_DELAY = 700L

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
        val isValid = formValidationUseCase.validateRegisterUsername(form.username)
        setIsUsernameValid(isValid)
    }

    fun onEmailChanged() {
        val isValid = formValidationUseCase.validateRegisterEmail(form.email)
        setIsEmailValid(isValid)
    }

    fun onPasswordChanged() {
        val isValid = formValidationUseCase.validateRegisterPassword(form.password)
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
        viewModelScope.launch(IO) {
            registerState.postValue(State.Loading())

            val state = registerPlayerUseCase.register(getRequestBody())
            delay(REGISTER_DELAY)

            registerState.postValue(state)
        }
    }

    private fun getRequestBody() = RegisterRequestBody(form.username, form.email, form.password)
}
