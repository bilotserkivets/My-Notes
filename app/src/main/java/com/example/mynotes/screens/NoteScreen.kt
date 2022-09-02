package com.example.mynotes.screens

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mynotes.NotesViewModel
import com.example.mynotes.NotesViewModelFactory
import com.example.mynotes.R
import com.example.mynotes.model.Note
import com.example.mynotes.navigation.NotesNavRoute
import com.example.mynotes.ui.theme.Green800
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun NoteScreen(navController: NavHostController, viewModel: NotesViewModel, noteId: String?) {

    val notes = viewModel.getAllNotes().observeAsState(listOf()).value
    val note = notes.firstOrNull {
        it.id == noteId?.toInt() } ?: Note(
            noteTitle = stringResource(id = R.string.empty),
            noteDescription = stringResource(id = R.string.empty),
            createDataNote = stringResource(id = R.string.empty)
        )

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Green800,
                contentColor = Color.White,
                modifier = Modifier.height(56.dp)
            ) {
                Row(modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                ) {
                    Row(modifier = Modifier.fillMaxWidth(0.2f)) {
                        IconButton(onClick = {
                                navController.navigate(NotesNavRoute.MainScreen.route)
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_check),
                                contentDescription = stringResource(id = R.string.check_image),
                                modifier = Modifier.size(40.dp)
                            )
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        IconButton(onClick = {
                                navController.navigate(NotesNavRoute.EditNoteScreen.route + "/${note.id}")
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_edit),
                                contentDescription = stringResource(id = R.string.icon_edit),
                                modifier = Modifier.size(40.dp)
                            )
                        }
                        IconButton(onClick = {
                            viewModel.deleteNote(note = note) {
                                navController.navigate(NotesNavRoute.MainScreen.route)
                            }
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_delete),
                                contentDescription = stringResource(id = R.string.check_delete),
                                modifier = Modifier.size(40.dp)
                            )
                        }
                        IconButton(onClick = {
                            /*TODO*/
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_menu),
                                contentDescription = stringResource(id = R.string.menu_image),
                                modifier = Modifier.size(40.dp)
                            )
                        }
                    }
                }
            }
        },
        content = {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
            ) {
                Text(
                    text = note.noteTitle,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                )
                Divider(color = Green800, thickness = 2.dp)
                Text(
                    text = note.noteDescription,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
    )
}

//@Preview(showBackground = true)
//@Composable
//fun NoteScreenPrev() {
//    val context = LocalContext.current
//    val nViewModel: NotesViewModel =
//        viewModel(factory = NotesViewModelFactory(context.applicationContext as Application))
//    val navController = rememberNavController()
//    NoteScreen(navController, nViewModel, noteId = )
//}