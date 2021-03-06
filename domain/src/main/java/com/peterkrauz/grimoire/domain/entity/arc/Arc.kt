package com.peterkrauz.grimoire.domain.entity.arc

data class Arc(
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
