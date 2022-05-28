package me.kovp.feature_network.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class AuthRetrofitProvider(
    private val okHttpClient: OkHttpClient
) : RetrofitProvider {
    override fun get(): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    companion object {
        private const val BASE_URL = "http://192.168.1.4:8080/"
    }
}