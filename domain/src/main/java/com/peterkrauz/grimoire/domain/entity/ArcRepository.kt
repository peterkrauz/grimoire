package com.peterkrauz.grimoire.domain.entity

interface ArcRepository {

    suspend fun findAll(): List<Arc>
    suspend fun createArc(form: CreateArcForm): Arc
}
