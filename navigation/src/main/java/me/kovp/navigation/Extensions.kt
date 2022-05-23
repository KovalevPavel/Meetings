package me.kovp.navigation

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import org.koin.core.context.loadKoinModules
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.module

fun LifecycleOwner.bindNavigation(@IdRes id: Int = 0, qualifier: Qualifier? = null) {
    loadKoinModules(
        module {
            single(qualifier = qualifier) {
                val navController = when (this@bindNavigation) {
                    is AppCompatActivity -> {
                        if (id == 0) throw RuntimeException("viewId must not be 0!")
                        findNavController(viewId = id)
                    }
                    is Fragment -> {
                        val navHost = childFragmentManager.findFragmentById(id) as NavHostFragment
                        navHost.findNavController()
                    }
                    else -> {
                        throw RuntimeException("Unexpected lifecycle owner ${this@bindNavigation}")
                    }
                }

                AppRouter(navController = navController)
            }
        }
    )
}