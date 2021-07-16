package com.example.quizler.di.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.quizler.domain.data.local.LocalRepository
import com.example.quizler.domain.data.remote.RemoteRepository
import com.example.quizler.feature.onboarding.AuthFormValidationUseCase
import com.example.quizler.feature.onboarding.register.RegisterBindingModel
import com.example.quizler.feature.onboarding.register.RegisterForm
import com.example.quizler.feature.onboarding.register.RegisterPlayerUserCaseMapper
import com.example.quizler.feature.onboarding.register.RegisterResponseHandler
import com.example.quizler.feature.onboarding.register.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RegisterModule {

    @Provides
    fun provideRegisterPlayerUseCase(
        remoteRepo: RemoteRepository,
        localRepo: LocalRepository,
        registerOutcomeHandler: RegisterResponseHandler
    ) = RegisterUseCase(remoteRepo, localRepo, registerOutcomeHandler)

    @Provides
    fun provideRegisterPlayerUseCaseMapper() = RegisterPlayerUserCaseMapper()

    @Provides
    fun provideRegisterForm() = RegisterForm()

    @Provides
    fun provideRegisterObservable() = MutableLiveData(RegisterBindingModel())

    @Provides
    fun provideRegisterOutcomeHandler() = RegisterResponseHandler()

    @Provides
    fun provideAuthFormValidationUseCase() = AuthFormValidationUseCase()
}
