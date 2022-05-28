package me.kovp.feature_network.retrofit

import retrofit2.Retrofit

interface RetrofitProvider {
    fun get(): Retrofit
}