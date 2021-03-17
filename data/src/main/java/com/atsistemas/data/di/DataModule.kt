package com.atsistemas.data.di

import com.atsistemas.data.di.providers.*
import com.atsistemas.data.repositories.DataStoreRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Juan Manuel Rincón on 3/8/21.
 */

val dataModule = module {

    single { provideOkHttpClient(get()) }
    single { provideMockInterceptor(get()) }
    single { provideGson()}
    single { provideRetrofit( get(), get())}
    single { provideTransactionApi( get() )}
    single { provideBankDatabase( get() ) }
    single { provideTransactionRepository( get(), get() )}
    single { provideDataStore(get()) }

}