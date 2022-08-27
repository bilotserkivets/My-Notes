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
    @ColumnInfo(name = "category_id") val categoryName: Int,
    @ColumnInfo(name = "image_note") val imageNote: String?,
    @ColumnInfo(name = "attachment_note") val attachmentNote: String?,
    @ColumnInfo(name = "fasten_note") val fastenNote: Boolean?,

)
