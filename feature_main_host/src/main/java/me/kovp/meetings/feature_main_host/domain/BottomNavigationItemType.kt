package me.kovp.meetings.feature_main_host.domain

enum class BottomNavigationItemType(val id: String) {
    EVENTS("events"),
    PROFILE("profile"),
    DEFAULT("");

    companion object {
        fun findById(id: String) = values().firstOrNull { it.id == id } ?: DEFAULT
    }
}
