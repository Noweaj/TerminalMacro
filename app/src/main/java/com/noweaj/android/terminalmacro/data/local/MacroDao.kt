package com.noweaj.android.terminalmacro.data.local

import androidx.room.*
import com.noweaj.android.terminalmacro.data.entity.MacroEntity

@Dao
interface MacroDao {
    @Query("SELECT * FROM macroENTITY where id = :id")
    fun getEntity(id: Int): MacroEntity
    
    @Query("SELECT * FROM macroENTITY")
    fun getAllEntities(): List<MacroEntity>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEntity(entity: MacroEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEntities(entities: List<MacroEntity>): List<Long>
    
    @Delete
    fun deleteEntity(entity: MacroEntity): Int
    
    @Query("DELETE FROM macroENTITY")
    fun deleteAllEntities()
}