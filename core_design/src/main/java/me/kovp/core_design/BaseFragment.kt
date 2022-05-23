package me.kovp.core_design

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

abstract class BaseFragment(@LayoutRes layout: Int = 0) : Fragment(layout) {
    open val moduleProvider: Module.() -> Unit = {}
    private val module: Module
        get() = module {
            scope(named(this@BaseFragment.javaClass.toString())) {
                moduleProvider()
            }
        }

    open fun initUi() {}
    open fun initUx() {}
    open fun initViewModelObservers() {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        initUx()
        initViewModelObservers()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        loadKoinModules(module)
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        unloadKoinModules(module)
        super.onDestroy()
    }

    fun <T> LiveData<T>.observe(consumer: (T) -> Unit) {
        this.observe(viewLifecycleOwner, consumer)
    }
}