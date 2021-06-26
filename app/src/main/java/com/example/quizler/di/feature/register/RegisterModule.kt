package com.example.quizler.di.feature.register

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
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RegisterModule {

    @Singleton
    @Provides
    fun provideRegisterPlayerUseCaseMapper(): RegisterPlayerUserCaseMapper {
        return RegisterPlayerUserCaseMapper()
    }

    @Singleton
    @Provides
    fun provideRegisterForm() = RegisterForm()

    @Singleton
    @Provides
    fun provideRegisterPlayerUseCase(
        remoteRepo: RemoteRepository,
        localRepo: LocalRepository,
        registerOutcomeHandler: RegisterResponseHandler
    ) = RegisterUseCase(remoteRepo, localRepo, registerOutcomeHandler)

    @Singleton
    @Provides
    fun provideRegisterObservable() = MutableLiveData(RegisterBindingModel())

    @Singleton
    @Provides
    fun provideRegisterOutcomeHandler() = RegisterResponseHandler()

    @Singleton
    @Provides
    fun provideAuthFormValidationUseCase() = AuthFormValidationUseCase()
}
