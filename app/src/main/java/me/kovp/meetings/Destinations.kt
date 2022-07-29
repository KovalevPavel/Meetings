package me.kovp.meetings

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.spec.DestinationStyle
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
//        SplashScreenDestination.replace(GetCodeScreenDestination, navigator)
        navigator.navigate(GetCodeScreenDestination)
    }
}

@Destination(style = DestinationStyle.BottomSheet::class)
@Composable
fun GetCodeScreen(
    navigator: DestinationsNavigator
) {
    GetCodeCompose { nickName ->
//        GetCodeScreenDestination.replace(ConfirmCodeScreenDestination(nickName), navigator)
    }
}

@Destination
@Composable
fun ConfirmCodeScreen(
    nickName: String,
    navigator: DestinationsNavigator
) {
}