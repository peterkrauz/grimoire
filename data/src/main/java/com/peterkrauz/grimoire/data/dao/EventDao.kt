package com.peterkrauz.grimoire.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.peterkrauz.grimoire.data.entity.EventEntity

@Dao
interface EventDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(event: EventEntity): Long

    @Query("SELECT * FROM event")
    suspend fun findAll(): List<EventEntity>
}
