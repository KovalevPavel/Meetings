package me.kovp.core_design.delegate_adapter

import java.util.UUID

abstract class ItemViewStates {
    open val id: String = UUID.randomUUID().toString()
}