package com.example.mynotes.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "checklist")
data class Checklist(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "title") val titleChecklist: String,
    @ColumnInfo(name = "subtitle") val subtitle: String,
    @ColumnInfo(name = "create_data") val createDataNote: String,
    @ColumnInfo(name = "category_id") val categoryName: Int,
    @ColumnInfo(name = "done") val done: Boolean
)
