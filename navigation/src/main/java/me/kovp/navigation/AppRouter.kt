package me.kovp.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import me.kovp.navigation.NavigationCommand.Back
import me.kovp.navigation.NavigationCommand.Forward
import me.kovp.navigation.NavigationCommand.Replace

class AppRouter(
    private val navController: NavController
) {
    private val nodes = navController.graph.nodes

    fun handleNavigationCommand(command: NavigationCommand) {
        when (command) {
            is Forward -> navigate(command.screen)
            is Replace -> replace(command.screen)
            is Back -> back()
        }
    }

    private fun navigate(screen: Screen) {
        val desiredDestination = nodes.get(screen.destination)

        desiredDestination?.let {
            navController.navigate(
                resId = screen.destination,
                args = screen.args
            )
        }
    }

    private fun replace(screen: Screen) {
        val desiredDestination = nodes.get(screen.destination)
        val navOptions = NavOptions.Builder()
            .setPopUpTo(navController.currentDestination?.id ?: 0, inclusive = true)
            .build()

        desiredDestination?.let {
            navController.navigate(
                resId = screen.destination,
                args = screen.args,
                navOptions = navOptions
            )
        }
    }

    private fun back() {
        navController.navigateUp()
    }
}