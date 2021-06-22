package com.example.quizler.feature.onboarding.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizler.domain.data.remote.request.LoginRequestBody
import com.example.quizler.domain.model.LoginBindingModel
import com.example.quizler.util.SingleLiveEvent
import com.example.quizler.util.State
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class LoginViewModel
@Inject constructor(
    val bindingModel: MutableLiveData<LoginBindingModel>,
    private val useCase: LoginUseCase
) : ViewModel() {

    val loginState: SingleLiveEvent<State<Boolean>> = SingleLiveEvent()

    fun login() {
        viewModelScope.launch {
//            val requestBody = LoginRequestBody(bindingModel.value!!.username, bindingModel.value!!.password)
//            val value = useCase.login(requestBody)
//            loginState.postValue(value)
            loginState.postValue(State.Loading())
            delay(2000)
            loginState.postValue(State.Success(true))
        }
    }

}