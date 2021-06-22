package com.example.quizler.di.feature.register

import androidx.lifecycle.MutableLiveData
import com.example.quizler.domain.data.local.LocalRepository
import com.example.quizler.domain.data.remote.RemoteRepository
import com.example.quizler.feature.onboarding.auth.register.RegisterForm
import com.example.quizler.feature.onboarding.auth.register.RegisterBindingModel
import com.example.quizler.feature.onboarding.auth.register.RegisterResponseHandler
import com.example.quizler.feature.onboarding.auth.register.RegisterPlayerUserCaseMapper
import com.example.quizler.feature.onboarding.auth.register.RegisterUseCase
import com.example.quizler.feature.onboarding.auth.usecase.AuthFormValidationUseCase
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
