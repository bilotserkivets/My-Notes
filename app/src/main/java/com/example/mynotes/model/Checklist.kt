package com.example.mynotes.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "checklist_table")
data class Checklist(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "title") val titleChecklist: String,
    @ColumnInfo(name = "subtitle") val subtitleChecklist: String,
    @ColumnInfo(name = "create_data") val createDataChecklist: String,
    @ColumnInfo(name = "category_id") val categoryId: Int = 1,
    @ColumnInfo(name = "done") val done: Boolean = false,
    @ColumnInfo(name = "data_update") val dataUpdateChecklist: String? = null,
    @ColumnInfo(name = "trash") val trashChecklist: Boolean? = null
)
