package com.peterkrauz.grimoire.domain.entity

class Arc(
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
