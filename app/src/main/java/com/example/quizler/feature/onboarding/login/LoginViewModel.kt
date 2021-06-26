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
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val LOGIN_DELAY = 700L

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
        val isValid = formValidationUseCase.validateLoginUsername(form.username)
        setIsUsernameValid(isValid)
    }

    fun onPasswordChanged() {
        val isValid = formValidationUseCase.validateLoginPassword(form.password)
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
        viewModelScope.launch(IO) {
            loginState.postValue(State.Loading())

            val value = useCase.login(getLoginRequestBody())
            delay(LOGIN_DELAY)

            loginState.postValue(value)
        }
    }

    private fun getLoginRequestBody() = LoginRequestBody(form.username, form.password)
}
