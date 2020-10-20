package com.peterkrauz.grimoire.domain.entity

interface ArcRepository {

    suspend fun createArc(form: CreateArcForm): Arc
}
