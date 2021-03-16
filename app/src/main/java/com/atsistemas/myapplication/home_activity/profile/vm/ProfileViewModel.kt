package com.atsistemas.myapplication.home_activity.profile.vm

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.*
import com.atsistemas.myapplication.R
import com.atsistemas.myapplication.commons.BaseViewModel
import com.atsistemas.myapplication.commons.Constants.USER_NAME
import com.atsistemas.myapplication.commons.Constants.USER_SURNAME
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.lang.Exception

class ProfileViewModel(private val application: Application): BaseViewModel() {

    private val Application.dataStore : DataStore<Preferences> by preferencesDataStore(name = "settings")

    val username = application.dataStore.data.map { settings ->
        settings[USER_NAME]
    }.asLiveData()

    val usersurname = application.dataStore.data.map { settings ->
        settings[USER_SURNAME]
    }.asLiveData()

    fun saveUser(name: String, surname: String) {
        _isLoading.value = true
        viewModelScope.launch (Dispatchers.IO){
           try {
               application.dataStore.edit { settings ->
                   settings[USER_NAME] = name
                   settings[USER_SURNAME] = surname
               }
           } catch (ie: Exception) {
               _showError.postValue(application.getString(R.string.error_saving))
           }

            _isLoading.postValue(false)
            showMessage(application.getString(R.string.save_successful))
        }
    }
}