package com.example.mynotes.navigation

import java.util.*

sealed class NotesNavRoute(val route: String) {
    object MainScreen: NotesNavRoute(route = "main_screen")
    object NoteScreen: NotesNavRoute(route = "note_screen")
    object ChecklistScreen: NotesNavRoute(route = "checklist_screen")
}

