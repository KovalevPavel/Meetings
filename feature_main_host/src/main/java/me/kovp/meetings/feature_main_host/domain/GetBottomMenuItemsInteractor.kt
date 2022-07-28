package me.kovp.meetings.feature_main_host.domain

import me.kovp.meetings.feature_main_host.domain.BottomNavigationItemType.EVENTS
import me.kovp.meetings.feature_main_host.domain.BottomNavigationItemType.PROFILE

class GetBottomMenuItemsInteractor {
    suspend operator fun invoke(): List<BottomMenuItemVo> {
        return listOf(
            BottomMenuItemVo(
                type = EVENTS,
                title = "События"
            ),
            BottomMenuItemVo(
                type = PROFILE,
                title = "Профиль"
            )
        )
    }
}
