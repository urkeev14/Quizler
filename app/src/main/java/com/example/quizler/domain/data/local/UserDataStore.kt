package com.example.quizler.domain.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserDataStore
@Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    val token: Flow<String?> = dataStore.data.map { preferences ->
        preferences[KEY_TOKEN]
    }
    val playerId: Flow<String?> = dataStore.data.map { preferences ->
        preferences[KEY_PLAYER_ID]
    }

    suspend fun cachePlayerData(playerId: String, token: String) {
        dataStore.edit { preferences ->
            preferences[KEY_PLAYER_ID] = playerId
            preferences[KEY_TOKEN] = token
        }
    }

    private companion object {
        val KEY_PLAYER_ID = stringPreferencesKey("keyPlayerId")
        val KEY_TOKEN = stringPreferencesKey("keyToken")
    }
}
