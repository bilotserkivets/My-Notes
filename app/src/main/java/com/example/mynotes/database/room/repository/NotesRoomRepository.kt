package com.example.mynotes.database.room.repository

import androidx.lifecycle.LiveData
import com.example.mynotes.database.DatabaseRepository
import com.example.mynotes.database.room.dao.NotesRoomDao
import com.example.mynotes.model.Category
import com.example.mynotes.model.Checklist
import com.example.mynotes.model.Note

class NotesRoomRepository(private val notesRoomDao: NotesRoomDao) : DatabaseRepository {
    override val readAllNotes: LiveData<List<Note>>
        get() = notesRoomDao.getAllNote()

    override  fun getNoteItem(noteId: Int) : Note {
        return notesRoomDao.getNoteItem(noteId = noteId)
    }

    override suspend fun createNote(note: Note, onSuccess: () -> Unit) {
        notesRoomDao.createNote(note = note)
        onSuccess()
    }

    override suspend fun updateNote(note: Note, onSuccess: () -> Unit) {
        notesRoomDao.updateNote(note = note)
        onSuccess()
    }

    override suspend fun deleteNote(note: Note, onSuccess: () -> Unit) {
        notesRoomDao.deleteNote(note = note)
        onSuccess()
    }

    override val readAllChecklists: LiveData<List<Checklist>>
        get() = notesRoomDao.getAllChecklist()

    override suspend fun createChecklist(checklist: Checklist, onSuccess: () -> Unit) {
        notesRoomDao.createChecklist(checklist = checklist)
        onSuccess()
    }

    override suspend fun updateChecklist(checklist: Checklist, onSuccess: () -> Unit) {
        notesRoomDao.updateChecklist(checklist = checklist)
        onSuccess()
    }

    override suspend fun deleteChecklist(checklist: Checklist, onSuccess: () -> Unit) {
        notesRoomDao.deleteChecklist(checklist = checklist)
        onSuccess()
    }

    override val readAllCategories: LiveData<List<Category>>
        get() = notesRoomDao.getAllCategory()

    override suspend fun createCategory(category: Category, onSuccess: () -> Unit) {
        notesRoomDao.createCategory(category = category)
        onSuccess()
    }

    override suspend fun updateCategory(category: Category, onSuccess: () -> Unit) {
        notesRoomDao.updateCategory(category = category)
        onSuccess()
    }

    override suspend fun deleteCategory(category: Category, onSuccess: () -> Unit) {
        notesRoomDao.deleteCategory(category = category)
        onSuccess()
    }
}