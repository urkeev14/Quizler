package com.example.quizler.di.app

import com.example.quizler.BuildConfig
import com.example.quizler.domain.data.remote.RemoteRepository
import com.example.quizler.domain.data.remote.service.player.PlayerService
import com.example.quizler.domain.data.remote.service.quiz_mode.QuizModeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryRemoteModule {

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(15, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .build()

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
