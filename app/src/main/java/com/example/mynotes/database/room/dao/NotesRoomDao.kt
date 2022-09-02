package com.example.mynotes.database.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mynotes.model.Category
import com.example.mynotes.model.Checklist
import com.example.mynotes.model.Note

@Dao
interface NotesRoomDao {
    // Operation with notes_table
    @Query("SELECT * FROM notes_table")
    fun getAllNote(): LiveData<List<Note>>

    @Query("SELECT * FROM notes_table WHERE id LIKE :noteId LIMIT 1")
    fun getNoteItem(noteId: Int) : Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    // Operation with checklist_table
    @Query("SELECT * FROM checklist_table")
    fun getAllChecklist(): LiveData<List<Checklist>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createChecklist(checklist: Checklist)

    @Update
    suspend fun updateChecklist(checklist: Checklist)

    @Delete
    suspend fun deleteChecklist(checklist: Checklist)

    // Operation with category_table
    @Query("SELECT * FROM category_table")
    fun getAllCategory(): LiveData<List<Category>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createCategory(category: Category)

    @Update
    suspend fun updateCategory(category: Category)

    @Delete
    suspend fun deleteCategory(category: Category)

}