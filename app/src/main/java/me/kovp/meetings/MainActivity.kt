package me.kovp.meetings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.defaults.NestedNavGraphDefaultAnimations
import com.ramcosta.composedestinations.animations.defaults.RootNavGraphDefaultAnimations
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import me.kovp.core_design.theme.meetingsLightColors

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(
                colors = meetingsLightColors
            ) {
                val animatedNavHostEngine = rememberAnimatedNavHostEngine(
                    navHostContentAlignment = Alignment.TopCenter,
                    rootDefaultAnimations = RootNavGraphDefaultAnimations.ACCOMPANIST_FADING,
                    defaultAnimationsForNestedNavGraph = mapOf(
                        NavGraphs.root to NestedNavGraphDefaultAnimations(
                            enterTransition = { fadeIn(animationSpec = tween(2000)) },
                            exitTransition = { fadeOut(animationSpec = tween(2000)) }
                        )
                    )
                )

                val navController = rememberAnimatedNavController()

                Surface(color = MaterialTheme.colors.surface, modifier = Modifier.fillMaxSize()) {

                    DestinationsNavHost(
                        navGraph = NavGraphs.root,
                        engine = animatedNavHostEngine,
                        navController = navController
                    )
                }
            }
        }
    }
}
