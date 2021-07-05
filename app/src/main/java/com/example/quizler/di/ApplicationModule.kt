package com.example.quizler.di

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.MutableLiveData
import com.example.quizler.BuildConfig
import com.example.quizler.domain.data.local.LocalRepository
import com.example.quizler.domain.data.remote.RemoteRepository
import com.example.quizler.domain.data.remote.service.player.PlayerService
import com.example.quizler.domain.data.remote.service.quiz_mode.QuizModeService
import com.example.quizler.domain.model.QuizMode
import com.example.quizler.feature.main.home.quiz_mode.QuizModeScreenDirectionResolver
import com.example.quizler.util.State
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DifficultyQuizModeListState

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LengthQuizModeListState

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    private val Context.authDataStore by preferencesDataStore(name = "auth_data_store")

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
    fun provideRemoteRepository(playerService: PlayerService, quizModeService: QuizModeService): RemoteRepository {
        return RemoteRepository(playerService, quizModeService)
    }

    @Singleton
    @Provides
    fun provideLocalRepository(@ApplicationContext context: Context): LocalRepository {
        return LocalRepository(context.authDataStore)
    }

    @Singleton
    @Provides
    fun providePlayerService(retrofit: Retrofit) = retrofit.create(PlayerService::class.java)

    @Singleton
    @Provides
    fun provideQuizModeService(retrofit: Retrofit) = retrofit.create(QuizModeService::class.java)

    @Singleton
    @Provides
    fun provideQuizModeScreenDirectionResolver() = QuizModeScreenDirectionResolver()

    @DifficultyQuizModeListState
    @Singleton
    @Provides
    fun provideDifficultyQuizModeListState() = MutableLiveData<State<List<QuizMode>>>(State.Loading())

    @LengthQuizModeListState
    @Singleton
    @Provides
    fun provideLengthQuizModeListState() = MutableLiveData<State<List<QuizMode>>>(State.Loading())
}
