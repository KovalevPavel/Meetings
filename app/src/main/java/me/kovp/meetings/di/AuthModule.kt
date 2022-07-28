package me.kovp.meetings.di

import me.kovp.domain_auth.AuthHolder
import me.kovp.meetings.auth.AuthHolderImpl
import org.koin.dsl.module

fun authModule() = module {
    single<AuthHolder> { AuthHolderImpl(context = get()) }
}