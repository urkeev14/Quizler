package com.example.quizler.feature.onboarding.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizler.domain.data.remote.request.LoginRequestBody
import com.example.quizler.feature.onboarding.AuthFormValidationUseCase
import com.example.quizler.util.SingleLiveEvent
import com.example.quizler.util.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
@Inject constructor(
    val form: LoginForm,
    val loginState: SingleLiveEvent<State<Boolean>>,
    private val useCase: LoginUseCase,
    private val formValidationUseCase: AuthFormValidationUseCase,
    private val _bindingModel: MutableLiveData<LoginBindingModel>,
) : ViewModel() {

    val bindingModel: LiveData<LoginBindingModel> = _bindingModel

    fun onUsernameChanged() {
        val isValid = formValidationUseCase.validateUsernameForLogin(form.username)
        setIsUsernameValid(isValid)
    }

    fun onPasswordChanged() {
        val isValid = formValidationUseCase.validatePasswordForLogin(form.password)
        setIsPasswordValid(isValid)
    }

    private fun setIsUsernameValid(isValid: Boolean) {
        _bindingModel.postValue(
            _bindingModel.value!!.copy(
                isUsernameValid = isValid
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

    fun login() {
        viewModelScope.launch {
            loginState.postValue(State.Loading())

            val value = useCase.login(getLoginRequestBody())
            delay(1500)

            loginState.postValue(value)
        }
    }

    private fun getLoginRequestBody() = LoginRequestBody(form.username, form.password)
}
