package me.kovp.feature_network.okhttp

import okhttp3.OkHttpClient

interface OkHttpClientProvider {
    fun get(): OkHttpClient
}