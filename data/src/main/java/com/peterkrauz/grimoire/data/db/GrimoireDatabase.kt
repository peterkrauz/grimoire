package com.peterkrauz.grimoire.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.peterkrauz.grimoire.data.dao.ArcDao
import com.peterkrauz.grimoire.data.dao.EventDao
import com.peterkrauz.grimoire.data.entity.ArcEntity
import com.peterkrauz.grimoire.data.entity.EventEntity

@Database(
    entities = [
        ArcEntity::class,
        EventEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class GrimoireDatabase : RoomDatabase() {

    abstract fun arcDao(): ArcDao
    abstract fun eventDao(): EventDao
}
