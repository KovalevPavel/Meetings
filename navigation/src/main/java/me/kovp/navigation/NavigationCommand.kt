package me.kovp.navigation

sealed class NavigationCommand {
    class Forward(val screen: Screen) : NavigationCommand()
    class Replace(val screen: Screen) : NavigationCommand()
    object Back : NavigationCommand()
}