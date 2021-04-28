package com.peterkrauz.grimoire.domain

import com.peterkrauz.grimoire.domain.entity.arc.Arc

object Fixtures {

    object Arcs {
        operator fun invoke(): List<Arc> {
            return listOf(
                Arc(
                    1, "Test", "Test"
                )
            )
        }
    }
}
