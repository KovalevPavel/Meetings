package me.kovp.meetings

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class MeetingsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initDi()
        initLogging()
        initDateTime()
    }

    private fun initLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initDateTime() {
        AndroidThreeTen.init(this)
    }

    private fun initDi() {
        startKoin {
            androidContext(this@MeetingsApp)
        }
    }
}