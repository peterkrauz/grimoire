package com.peterkrauz.grimoire.domain.entity.event

data class Event(
    val id: Long,
    val title: String,
    val description: String
) {
    interface Abstraction {
        val id: Long
        val title: String
        val description: String
    }
}
