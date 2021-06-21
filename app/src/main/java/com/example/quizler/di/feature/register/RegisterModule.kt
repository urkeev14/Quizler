package com.example.quizler.di.feature.register

import androidx.lifecycle.MutableLiveData
import com.example.quizler.domain.data.local.LocalRepository
import com.example.quizler.domain.data.remote.RemoteRepository
import com.example.quizler.domain.data.remote.service.player.PlayerService
import com.example.quizler.domain.model.RegisterForm
import com.example.quizler.feature.onboarding.auth.register.RegisterObservable
import com.example.quizler.feature.onboarding.auth.register.RegisterOutcomeHandler
import com.example.quizler.feature.onboarding.auth.register.RegisterPlayerUserCaseMapper
import com.example.quizler.feature.onboarding.auth.register.RegisterUseCase
import com.example.quizler.feature.onboarding.auth.usecase.AuthFormValidationUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

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
        registerOutcomeHandler: RegisterOutcomeHandler
    ) = RegisterUseCase(remoteRepo, localRepo, registerOutcomeHandler)

    @Singleton
    @Provides
    fun provideRegisterObservable() = MutableLiveData(RegisterObservable())

    @Singleton
    @Provides
    fun provideRegisterOutcomeHandler() = RegisterOutcomeHandler()

    @Singleton
    @Provides
    fun provideAuthFormValidationUseCase() = AuthFormValidationUseCase()

    @Singleton
    @Provides
    fun providePlayerService(retrofit: Retrofit) = retrofit.create(PlayerService::class.java)
}
