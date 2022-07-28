package me.kovp.meetings.auth

import android.content.Context
import me.kovp.domain_auth.AuthHolder

class AuthHolderImpl(
    context: Context
) : AuthHolder {
    override var token: String by stringSharedPrefs(context, TOKEN_KEY)

    companion object {
        private const val TOKEN_KEY = "TOKEN_KEY"
    }
}