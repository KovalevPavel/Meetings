package me.kovp.meetings

import android.os.Bundle
import me.kovp.navigation.Screen

object MainHostScreen : Screen {
    override val destination: Int = R.id.mainHostFragment
    override val args: Bundle? = null
}