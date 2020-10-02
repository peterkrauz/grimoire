package com.peterkrauz.grimoire.data.mapper

import com.peterkrauz.grimoire.data.entity.ArcEntity
import com.peterkrauz.grimoire.domain.entity.Arc

object ArcMapper {
    fun fromEntity(arcEntity: ArcEntity): Arc {
        return Arc(
            arcEntity.id,
            arcEntity.title,
            arcEntity.description
        )
    }
}
