package com.peterkrauz.grimoire.data.mapper

import com.peterkrauz.grimoire.data.entity.EventEntity
import com.peterkrauz.grimoire.domain.entity.event.Event

object EventMapper {
    fun fromEntity(eventEntity: EventEntity): Event {
        return Event(
            eventEntity.id,
            eventEntity.title,
            eventEntity.description
        )
    }
}
