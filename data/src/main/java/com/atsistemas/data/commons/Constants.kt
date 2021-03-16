package com.atsistemas.data.commons

import androidx.datastore.preferences.core.stringPreferencesKey

/**
 * Created by Juan Manuel Rincón on 3/10/21.
 */
object Constants {
    const val DATABASE_NAME = "bank_db"
    const val TABLE_TRANSACTIONS = "transaction"

    val USER_NAME = stringPreferencesKey("user_name")

    val USER_SURNAME = stringPreferencesKey("user_surname")
}