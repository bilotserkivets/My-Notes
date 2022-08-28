package com.example.mynotes.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_table")
data class Category(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "name_category") val nameCategory: String,
    @ColumnInfo(name = "data_update") val dataUpdateCategory: String? = null,
    @ColumnInfo(name = "trash") val trashCategory: Boolean? = null
)
