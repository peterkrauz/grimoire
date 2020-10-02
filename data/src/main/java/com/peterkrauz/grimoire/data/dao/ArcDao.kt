package com.peterkrauz.grimoire.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.peterkrauz.grimoire.data.entity.ArcEntity

@Dao
interface ArcDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(arc: ArcEntity): Long

    @Query("SELECT * FROM arc WHERE id = :arcId")
    suspend fun findById(arcId: Long): ArcEntity
}
