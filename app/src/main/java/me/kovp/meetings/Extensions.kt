package me.kovp.meetings

import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.spec.Direction
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec

fun DirectionDestinationSpec.replace(
    destination: Direction,
    navigator: DestinationsNavigator
) {
    navigator.navigate(destination) {
        popUpTo(this@replace.route) {
            inclusive = true
        }
    }
}

fun DestinationsNavigator.replace(destination: DirectionDestinationSpec) {
    this.navigate(destination) {
        popBackStack(destination.route, inclusive = false)
        clearBackStack(destination.route)
//        popUpTo(destination.route) {
//            inclusive = false
//        }
    }
}