package me.kovp.meetings.auth

import android.content.Context
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun stringSharedPrefs(context: Context, key: String) = StringSharedPrefDelegate(context, key)

class StringSharedPrefDelegate(
    context: Context,
    private val key: String
) : ReadWriteProperty<AuthHolderImpl, String> {
    private var cache: String? = null
    private val prefs = context.getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE)

    override fun getValue(thisRef: AuthHolderImpl, property: KProperty<*>): String {
        return cache
            ?: prefs.getString(key, "")
            ?: throw RuntimeException("Can't read shared prefs")
    }

    override fun setValue(thisRef: AuthHolderImpl, property: KProperty<*>, value: String) {
        cache = value
        prefs.edit()
            .putString(key, value)
            .apply()
    }

    companion object {
        private const val SHARED_PREFS_KEY = "SHARED_PREFS_KEY"
    }
}