package com.example.quizler.di.feature.login

import androidx.lifecycle.MutableLiveData
import com.example.quizler.domain.data.local.LocalRepository
import com.example.quizler.domain.data.remote.RemoteRepository
import com.example.quizler.feature.onboarding.login.LoginBindingModel
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
    fun provideLoginBindingModel(): LoginBindingModel {
        return LoginBindingModel()
    }

    @Provides
    fun provideLoginUseCase(localRepository: LocalRepository, remoteRepository: RemoteRepository): LoginUseCase {
        return LoginUseCase(localRepository, remoteRepository)
    }

    @Provides
    fun provideLoginSingleLiveEvent(): SingleLiveEvent<State<Boolean>> {
        return SingleLiveEvent()
    }
}