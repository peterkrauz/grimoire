package com.peterkrauz.grimoire.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.peterkrauz.grimoire.data.dao.ArcDao
import com.peterkrauz.grimoire.data.entity.ArcEntity

@Database(
    entities = [
        ArcEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class GrimoireDatabase : RoomDatabase() {

    abstract fun arcDao(): ArcDao
}
