package com.example.quizler.di

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import com.example.quizler.domain.data.local.LocalRepository
import com.example.quizler.domain.data.remote.RemoteRepository
import com.example.quizler.domain.data.remote.service.player.PlayerService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    private val Context.authDataStore by preferencesDataStore(name = "auth_data_store")

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://quizler.com")
            .build()
    }

    @Singleton
    @Provides
    fun provideRemoteRepository(playerService: PlayerService): RemoteRepository {
        return RemoteRepository(playerService)
    }

    @Singleton
    @Provides
    fun provideLocalRepository(@ApplicationContext context: Context): LocalRepository {
        return LocalRepository(context.authDataStore)
    }
}
