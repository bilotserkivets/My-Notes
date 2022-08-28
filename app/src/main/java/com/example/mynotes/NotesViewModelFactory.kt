package com.example.mynotes

import android.app.Application
import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NotesViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NotesViewModel::class.java)) {
            return NotesViewModel(application = application) as T
        }

        throw IllegalArgumentException("Unknown NoteViewModel class")
    }
}