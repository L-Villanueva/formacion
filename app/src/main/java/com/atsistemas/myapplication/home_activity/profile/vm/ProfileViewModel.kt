package com.atsistemas.myapplication.home_activity.profile.vm

import android.app.Application
import android.content.Context
import android.provider.Settings.Global.getString
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.*
import com.atsistemas.data.remote.ResultHandler
import com.atsistemas.data.repositories.DataStoreRepository
import com.atsistemas.myapplication.R
import com.atsistemas.myapplication.commons.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ProfileViewModel(private val repository: DataStoreRepository): BaseViewModel() {

    val username = repository.username.asLiveData()
    val usersurname = repository.usersurname.asLiveData()

     fun saveUser(name: String, surname: String){
         _isLoading.value = true
         viewModelScope.launch (Dispatchers.IO){
             when (val result = repository.saveUser(name, surname)){
                 is ResultHandler.Success -> {
                     showMessage(result.data)
                 }
                 else -> {
                     setShowError(result)
                 }
             }
             _isLoading.postValue(false)
         }
     }
}