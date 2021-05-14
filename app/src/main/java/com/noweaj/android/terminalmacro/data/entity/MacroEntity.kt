package com.noweaj.android.terminalmacro.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "macroENTITY")
data class MacroEntity (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var title: String,
    var description: String,
    var createdTimestamp: Long,
    var editedTimestamp: Long,
    var pinned: Boolean, // pinned macros will stay top
    var option: String
)