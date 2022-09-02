package com.example.mynotes

import android.app.Application
import android.util.Log
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynotes.database.room.AppRoomDatabase
import com.example.mynotes.database.room.repository.NotesRoomRepository
import com.example.mynotes.model.Note
import com.example.mynotes.utils.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application) : AndroidViewModel(application) {
    val context = application

    init {
        initDatabase {
            Log.d("init_database", "Initialization NotesDatabase: OK")
        }
    }

    private fun initDatabase(onSuccess: () -> Unit) {
        val dao = AppRoomDatabase.getInstance(context).getNotesRoomDao()
        REPOSITORY = NotesRoomRepository(dao)
        onSuccess()
    }

    fun getAllNotes() = REPOSITORY.readAllNotes

    fun createNote(note: Note, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.createNote(note = note) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun updateNote(note: Note, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.updateNote(note = note) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun deleteNote(note: Note, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deleteNote(note = note) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }
}