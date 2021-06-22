package com.example.quizler.feature.onboarding.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizler.domain.data.remote.request.LoginRequestBody
import com.example.quizler.util.SingleLiveEvent
import com.example.quizler.util.State
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class LoginViewModel
@Inject constructor(
    private val useCase: LoginUseCase,
    val loginState: SingleLiveEvent<State<Boolean>>,
    val loginBindingModel: LoginBindingModel,
) : ViewModel() {

    fun login() {
        viewModelScope.launch {
            loginState.postValue(State.Loading())

            val value = useCase.login(getLoginRequestBody())
            delay(1500)

            loginState.postValue(value)
        }
    }

    private fun getLoginRequestBody(): LoginRequestBody {
        val username = loginBindingModel.username
        val password = loginBindingModel.password
        return LoginRequestBody(username, password)
    }

}