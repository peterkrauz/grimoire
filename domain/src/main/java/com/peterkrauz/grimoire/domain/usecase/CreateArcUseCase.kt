package com.peterkrauz.grimoire.domain.usecase

import com.peterkrauz.grimoire.domain.entity.arc.Arc
import com.peterkrauz.grimoire.domain.entity.arc.ArcRepository
import com.peterkrauz.grimoire.domain.entity.arc.CreateArcForm
import javax.inject.Inject

class CreateArcUseCase @Inject constructor(private val repository: ArcRepository) {

    suspend fun createArc(title: String, description: String): Arc {
        val form = CreateArcForm(title, description)
        return repository.createArc(form)
    }
}
