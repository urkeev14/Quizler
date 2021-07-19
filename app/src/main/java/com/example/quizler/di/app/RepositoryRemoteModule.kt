package com.example.quizler.di.app

import com.example.quizler.BuildConfig
import com.example.quizler.domain.data.remote.RemoteRepository
import com.example.quizler.domain.data.remote.service.player.PlayerService
import com.example.quizler.domain.data.remote.service.quiz_mode.QuizModeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryRemoteModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideRemoteRepository(
        playerService: PlayerService,
        quizModeService: QuizModeService
    ) = RemoteRepository(playerService, quizModeService)

    @Singleton
    @Provides
    fun providePlayerService(retrofit: Retrofit): PlayerService = retrofit.create(PlayerService::class.java)

    @Singleton
    @Provides
    fun provideQuizModeService(retrofit: Retrofit): QuizModeService = retrofit.create(QuizModeService::class.java)
}
