package com.example.quizler.di.app

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.Room
import com.example.quizler.domain.data.local.QuizModeRepository
import com.example.quizler.domain.data.local.UserDataStore
import com.example.quizler.domain.data.local.db.quiz_mode.QuizModeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryLocalModule {

    private val Context.userDataStore by preferencesDataStore(name = "user_data_store")

    @Provides
    @Singleton
    fun provideQuizModeDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        QuizModeDatabase::class.java, "db_quizler"
    ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideLocalRepository(quizModeDatabase: QuizModeDatabase) = QuizModeRepository(quizModeDatabase)

    @Provides
    @Singleton
    fun provideUserDataStore(@ApplicationContext context: Context) = UserDataStore(context.userDataStore)
}
