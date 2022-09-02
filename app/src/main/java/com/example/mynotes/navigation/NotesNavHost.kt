package com.example.mynotes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mynotes.NotesViewModel
import com.example.mynotes.screens.*

@Composable
fun NotesNavHost(viewModel: NotesViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NotesNavRoute.MainScreen.route) {
        composable(NotesNavRoute.MainScreen.route) {
            MainScreen(navController = navController, viewModel = viewModel)
        }
        composable(NotesNavRoute.NoteScreen.route + "/{id}") { backStack ->
            NoteScreen(navController = navController, viewModel = viewModel, noteId = backStack.arguments?.getString("id"))
        }
        composable(NotesNavRoute.AddNoteScreen.route) {
            AddNoteScreen(navController = navController, viewModel = viewModel)
        }
        composable(NotesNavRoute.ChecklistScreen.route) {
            ChecklistScreen(navController = navController, viewModel = viewModel)
        }
        composable(NotesNavRoute.EditNoteScreen.route + "/{id}") { backStack ->
            EditNoteScreen(navController = navController, viewModel = viewModel, noteId = backStack.arguments?.getString("id"))
        }
    }
}