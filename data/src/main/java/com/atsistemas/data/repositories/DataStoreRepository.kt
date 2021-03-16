package com.atsistemas.data.repositories

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.atsistemas.data.R
import com.atsistemas.data.commons.BaseRepository
import com.atsistemas.data.commons.Constants.USER_NAME
import com.atsistemas.data.commons.Constants.USER_SURNAME
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map


class DataStoreRepository(private val context: Context): BaseRepository() {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("settings")

    val username = context.dataStore.data.map { settings ->
        settings[USER_NAME]
    }

    val usersurname = context.dataStore.data.map { settings ->
        settings[USER_SURNAME]
    }

    suspend fun saveUser(name: String, surname: String) {

        context.dataStore.edit { settings ->
            settings[USER_NAME] = name
            settings[USER_SURNAME] = surname

        }
    }
}