package me.kovp.meetings.feature_main_host.presentation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable

@Composable
fun MainHostCompose(
) {
    Scaffold(bottomBar = {
        BottomNavigation {
            BottomNavigationItem(
                icon = { Icon(imageVector = Icons.Default.Home, "") },
                label = { Text("Home") },
                selected = true,
                onClick = {}
            )
            BottomNavigationItem(
                icon = { Icon(imageVector = Icons.Default.Email, "") },
                label = { Text("Email") },
                selected = false,
                onClick = {}
            )
            BottomNavigationItem(
                icon = { Icon(imageVector = Icons.Default.Notifications, "") },
                label = { Text("Notifications") },
                selected = false,
                onClick = {}
            )
        }
    }) {
//        val navHostEngine = rememberNavHostEngine()

//        DestinationsNavHost(
//            navGraph = NavGraphs.root,
//            engine = navHostEngine,
//            navController = navController
//        )
    }
}