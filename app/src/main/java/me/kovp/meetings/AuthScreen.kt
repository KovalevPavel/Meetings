package me.kovp.meetings

import android.os.Bundle
import me.kovp.navigation.Screen

object AuthScreen : Screen {
    override val destination: Int = me.kovp.feature_auth_api.R.id.authFragment
    override val args: Bundle? = null
}