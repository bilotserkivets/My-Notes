package com.example.mynotes.database

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import com.example.mynotes.model.Category
import com.example.mynotes.model.Checklist
import com.example.mynotes.model.Note

interface DatabaseRepository {

    val readAllNotes: LiveData<List<Note>>

    suspend fun createNote(note: Note, onSuccess: () -> Unit)

    suspend fun updateNote(note: Note, onSuccess: () -> Unit)

    suspend fun deleteNote(note: Note, onSuccess: () -> Unit)


    val readAllChecklists: LiveData<List<Checklist>>

    suspend fun createChecklist(checklist: Checklist, onSuccess: () -> Unit)

    suspend fun updateChecklist(checklist: Checklist, onSuccess: () -> Unit)

    suspend fun deleteChecklist(checklist: Checklist, onSuccess: () -> Unit)


    val readAllCategories: LiveData<List<Category>>

    suspend fun createCategory(category: Category, onSuccess: () -> Unit)

    suspend fun updateCategory(category: Category, onSuccess: () -> Unit)

    suspend fun deleteCategory(category: Category, onSuccess: () -> Unit)
}