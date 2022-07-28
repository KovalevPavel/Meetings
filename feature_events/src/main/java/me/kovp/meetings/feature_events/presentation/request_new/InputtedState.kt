package me.kovp.meetings.feature_events.presentation.request_new

import android.graphics.Bitmap

data class InputtedState(
    val eventCover: Bitmap? = null,
    val eventTitle: Field<String> = Field(),
    val eventDescription: Field<String> = Field(),
    val eventDate: Field<Long> = Field(),
    val eventTime: Field<Long> = Field()
) {
    data class Field<T : Any>(
        val value: T? = null,
        val error: String = ""
    )
}
