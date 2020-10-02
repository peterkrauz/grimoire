package com.peterkrauz.grimoire.data.repository

import com.peterkrauz.grimoire.data.dao.ArcDao
import com.peterkrauz.grimoire.data.entity.ArcEntity
import com.peterkrauz.grimoire.data.mapper.ArcMapper
import com.peterkrauz.grimoire.domain.entity.Arc
import com.peterkrauz.grimoire.domain.entity.ArcRepository
import com.peterkrauz.grimoire.domain.entity.CreateArcForm
import javax.inject.Inject

class ArcRepositoryImpl @Inject constructor(private val dao: ArcDao) : ArcRepository {

    override suspend fun createArc(form: CreateArcForm): Arc {
        val entity = ArcEntity(form)
        val arcId = dao.insert(entity)
        return ArcMapper.fromEntity(dao.findById(arcId))
    }
}