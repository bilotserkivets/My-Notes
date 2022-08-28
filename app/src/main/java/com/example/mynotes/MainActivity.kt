package com.example.mynotes

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mynotes.navigation.NotesNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            val nViewModel: NotesViewModel =
                viewModel(factory = NotesViewModelFactory(context.applicationContext as Application))

            NotesNavHost(viewModel = nViewModel)
        }
    }
}
