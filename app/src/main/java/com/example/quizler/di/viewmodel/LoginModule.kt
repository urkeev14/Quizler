package com.example.quizler.di.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.quizler.domain.data.local.UserDataStore
import com.example.quizler.domain.data.remote.RemoteRepository
import com.example.quizler.feature.onboarding.login.LoginBindingModel
import com.example.quizler.feature.onboarding.login.LoginForm
import com.example.quizler.feature.onboarding.login.LoginUseCase
import com.example.quizler.util.SingleLiveEvent
import com.example.quizler.util.State
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class LoginModule {

    @Provides
    fun provideLoginUseCase(
        userDataStore: UserDataStore,
        remoteRepository: RemoteRepository
    ) = LoginUseCase(userDataStore, remoteRepository)

    @Provides
    fun provideLoginBindingModel() = MutableLiveData(LoginBindingModel())

    @Provides
    fun provideLoginSingleLiveEvent(): SingleLiveEvent<State<Boolean>> = SingleLiveEvent()

    @Provides
    fun provideLoginForm() = LoginForm()
}
