package me.kovp.meetings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.lightColors
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import com.ramcosta.composedestinations.DestinationsNavHost
import me.kovp.core_design.theme.meetingsLightColors
import me.kovp.meetings.feature_splash.splashModule
import org.koin.core.context.loadKoinModules

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(
                colors = meetingsLightColors
            ) {
                Surface(color = MaterialTheme.colors.surface, modifier = Modifier.fillMaxSize()) {
                    DestinationsNavHost(
                        navGraph = NavGraphs.root
                    )
                }
            }
        }
    }
}
