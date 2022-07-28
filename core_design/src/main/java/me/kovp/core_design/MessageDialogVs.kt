package me.kovp.core_design

import java.util.UUID

data class MessageDialogVs(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val positiveAction: String
)