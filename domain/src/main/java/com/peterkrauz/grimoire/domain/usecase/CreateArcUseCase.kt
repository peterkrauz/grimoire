package com.peterkrauz.grimoire.domain.usecase

import com.peterkrauz.grimoire.domain.entity.Arc
import com.peterkrauz.grimoire.domain.entity.ArcRepository
import com.peterkrauz.grimoire.domain.entity.CreateArcForm
import javax.inject.Inject

class CreateArcUseCase @Inject constructor(private val repository: ArcRepository) {

    suspend fun createArc(title: String, description: String): Arc {
        val form = CreateArcForm(title, description)
        return repository.createArc(form)
    }
}
