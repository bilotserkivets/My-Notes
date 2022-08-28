package com.example.mynotes.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "title") val noteTitle: String,
    @ColumnInfo(name = "description") val noteDescription: String,
    @ColumnInfo(name = "create_data") val createDataNote: String,
    @ColumnInfo(name = "category_id") val categoryId: Int = 1,
    @ColumnInfo(name = "image") val imageNote: String? = null,
    @ColumnInfo(name = "attachment_note") val attachmentNote: String? = null,
    @ColumnInfo(name = "fasten_note") val fastenNote: Boolean? = null,
    @ColumnInfo(name = "data_update") val dataUpdateNote: String? = null,
    @ColumnInfo(name = "trash") val trashNote: Boolean? = null

)
