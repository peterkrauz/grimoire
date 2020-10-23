package com.peterkrauz.grimoire.domain.entity

interface ArcRepository {

    suspend fun createArc(form: CreateArcForm): Arc
    suspend fun findAll(): List<Arc>
    suspend fun findById(arcId: Long): Arc
    suspend fun deleteById(arcId: Long)
}
