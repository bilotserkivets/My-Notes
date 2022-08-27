package com.example.mynotes.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_note")
data class CategoryNote(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "name_category") val nameCategory: String
)
