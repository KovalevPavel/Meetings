package me.kovp.feature_network.di

import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue

object Bot: Qualifier {
    override val value: QualifierValue
        get() = "bot_client"
}