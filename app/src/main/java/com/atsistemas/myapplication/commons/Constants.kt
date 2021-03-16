package com.atsistemas.myapplication.commons

import androidx.datastore.preferences.core.stringPreferencesKey

/**
 * Created by Juan Manuel Rincón on 3/8/21.
 */
object Constants {
    const val LOADING_SLEEP: Long = 2000

    //Errors
    const val NETWORK_ERROR = "Network Error"

    val USER_NAME = stringPreferencesKey("user_name")

    val USER_SURNAME = stringPreferencesKey("user_surname")
}