package com.peterkrauz.grimoire.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.peterkrauz.grimoire.domain.entity.event.CreateEventForm
import com.peterkrauz.grimoire.domain.entity.event.Event

@Entity(tableName = "event")
class EventEntity(
    @PrimaryKey(autoGenerate = true) override val id: Long,
    override val title: String,
    override val description: String
) : Event.Abstraction {
    constructor(form: CreateEventForm) : this(
        0, form.title, form.description
    )
}
