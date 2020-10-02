package com.peterkrauz.grimoire.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.peterkrauz.grimoire.domain.entity.Arc
import com.peterkrauz.grimoire.domain.entity.CreateArcForm

@Entity(tableName = "arc")
data class ArcEntity(
    @PrimaryKey(autoGenerate = true) override var id: Long,
    override val title: String,
    override val description: String
) : Arc.Abstraction {
    constructor(form: CreateArcForm) : this(
        0, form.title, form.description
    )
}
