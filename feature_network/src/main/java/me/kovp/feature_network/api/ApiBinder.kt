package me.kovp.feature_network.api

import me.kovp.feature_network.di.Auth
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier
import org.koin.java.KoinJavaComponent.inject
import retrofit2.Retrofit

inline fun <reified T : Any> Module.bindApi(qualifier: Qualifier? = Auth) {
    val retrofit: Retrofit by inject(Retrofit::class.java, qualifier = qualifier)
    single { retrofit.create(T::class.java) }
}