package me.kovp.navigation

abstract class BaseRouter {
    abstract fun navigate(screen: Screen)
    abstract fun replace(screen: Screen)
    abstract fun back()
}