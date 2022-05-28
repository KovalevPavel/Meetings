package me.kovp.feature_network.okhttp

import me.kovp.core_auth.AuthHolder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class AuthOkHttpClientProvider(
    private val authHolder: AuthHolder
) : OkHttpClientProvider {
    override fun get(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .addInterceptor(
                Interceptor {
                    val newRequest = it.request()
                        .newBuilder()
                        .addHeader(name = AUTH_HEADER, "Bearer ${authHolder.token}")
                        .build()
                    it.proceed(newRequest)
                }
            )
            .build()
    }

    companion object {
        private const val AUTH_HEADER = "Authorization"
    }
}