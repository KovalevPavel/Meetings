package me.kovp.navigation.di

import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue

object HostRouter: Qualifier {
    override val value: QualifierValue
        get() = "mainHostRouter"

}