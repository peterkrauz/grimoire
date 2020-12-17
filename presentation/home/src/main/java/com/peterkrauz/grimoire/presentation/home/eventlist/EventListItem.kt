package com.peterkrauz.grimoire.presentation.home.eventlist

import com.peterkrauz.grimoire.domain.entity.event.Event

sealed class EventListItem(val itemType: Int) {
    companion object {
        const val ARC_DESCRIPTION_TYPE = 1
        const val EVENT_TYPE = 2
    }
}

class ArcDescriptionItem(val description: String) : EventListItem(ARC_DESCRIPTION_TYPE)

class EventItem(val event: Event) : EventListItem(EVENT_TYPE)
