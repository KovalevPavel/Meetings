package me.kovp.feature_network.okhttp

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class NonAuthOkHttpClientProvider: OkHttpClientProvider {
    override fun get(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .build()
    }
}