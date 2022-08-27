package com.example.mynotes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mynotes.screens.ChecklistScreen
import com.example.mynotes.screens.MainScreen
import com.example.mynotes.screens.NoteScreen

@Composable
fun NotesNavHost () {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NotesNavRoute.MainScreen.route) {
        composable(NotesNavRoute.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(NotesNavRoute.NoteScreen.route) {
            NoteScreen(navController = navController)
        }
        composable(NotesNavRoute.ChecklistScreen.route) {
            ChecklistScreen(navController = navController)
        }
    }
}