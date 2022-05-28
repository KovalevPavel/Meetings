package me.kovp.feature_network.di

import me.kovp.feature_network.api.AuthApi
import me.kovp.feature_network.api.BotApi
import me.kovp.feature_network.api.ProfileInfoApi
import me.kovp.feature_network.api.bindApi
import me.kovp.feature_network.okhttp.AuthOkHttpClientProvider
import me.kovp.feature_network.okhttp.NonAuthOkHttpClientProvider
import me.kovp.feature_network.retrofit.AuthRetrofitProvider
import me.kovp.feature_network.retrofit.TgBotRetrofitProvider
import org.koin.dsl.module

fun networkModule() = module {
    single(qualifier = Auth) {
        AuthOkHttpClientProvider(authHolder = get()).get()
    }
    single(qualifier = Auth) {
        AuthRetrofitProvider(
            okHttpClient = get(qualifier = Auth)
        ).get()
    }

    single(qualifier = Bot) {
        NonAuthOkHttpClientProvider()
            .get()
    }
    single(qualifier = Bot) {
        TgBotRetrofitProvider(
            okHttpClient = get(qualifier = Bot)
        ).get()
    }

    bindApi<ProfileInfoApi>()
    bindApi<AuthApi>()
    bindApi<BotApi>(qualifier = Bot)
}