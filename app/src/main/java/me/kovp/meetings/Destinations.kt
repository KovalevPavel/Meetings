package me.kovp.meetings

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import me.kovp.feature_auth.presentation.GetCodeCompose
import me.kovp.meetings.destinations.GetCodeScreenDestination
import me.kovp.meetings.destinations.SplashScreenDestination
import me.kovp.meetings.feature_splash.SplashCompose

@RootNavGraph(start = true)
@Destination
@Composable
fun SplashScreen(
    navigator: DestinationsNavigator
) {
    SplashCompose {
        println("received event")
        navigator.navigate(GetCodeScreenDestination) {
            popUpTo(SplashScreenDestination.route) {
                inclusive = true
            }
        }

    }
}

@Destination
@Composable
fun GetCodeScreen(
    navigator: DestinationsNavigator
) {
    GetCodeCompose { }
}

@Destination
@Composable
fun ConfirmCodeScreen(
    navigator: DestinationsNavigator
) {
}