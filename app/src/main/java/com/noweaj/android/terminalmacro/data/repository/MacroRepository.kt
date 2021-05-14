package com.noweaj.android.terminalmacro.data.repository

import com.noweaj.android.terminalmacro.data.local.MacroDao
import com.noweaj.android.terminalmacro.data.performLocalGetAllEntitiesOperation

class MacroRepository(
    private val localMacroDataSource: MacroDao
) {
    fun getAllMacroEntities() =
        performLocalGetAllEntitiesOperation(
            databaseQuery = { localMacroDataSource.getAllEntities() }
        )
}