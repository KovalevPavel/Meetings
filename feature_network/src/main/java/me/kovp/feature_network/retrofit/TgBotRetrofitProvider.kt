package me.kovp.feature_network.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class TgBotRetrofitProvider(
    private val okHttpClient: OkHttpClient
): RetrofitProvider {
    override fun get(): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    companion object {
        private const val BASE_URL =
            "https://api.telegram.org/bot5390049969:AAH4F-sDLeLK37lvohQ_uyq2odrOl8Aq0Y0/"
    }
}