package me.kovp.navigation

import android.os.Bundle

interface Screen {
    val destination: Int
    val args: Bundle?
}