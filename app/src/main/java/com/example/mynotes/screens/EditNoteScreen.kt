package com.example.mynotes.screens

import android.app.Application
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
fun EditNoteScreen(navController: NavHostController, viewModel: NotesViewModel, noteId: String?) {
    var noteTitle by remember { mutableStateOf("empty") }
    var noteDescription by remember { mutableStateOf("empty") }

    val sdf = SimpleDateFormat("HH:mm dd.mm.yyyy")
    val currentDateAndTime = sdf.format(Date())

    val notes  = viewModel.getAllNotes().observeAsState(listOf()).value
    val note = notes.firstOrNull{ it.id == noteId?.toInt() } ?: Note(noteTitle = "Empty", noteDescription = "Empty", createDataNote = "Empty")

    noteTitle = note.noteTitle
    noteDescription = note.noteDescription

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Green800,
                contentColor = Color.White,
                modifier = Modifier.height(56.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                ) {
                    Row(modifier = Modifier.fillMaxWidth(0.2f)) {
                        IconButton(onClick = {

                            viewModel.updateNote(
                                Note(
                                    id = note.id,
                                    noteTitle = noteTitle,
                                    noteDescription = noteDescription,
                                    createDataNote = currentDateAndTime
                                )
                            ) {
                                navController.navigate(NotesNavRoute.MainScreen.route)
                            }
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                TextField(
                    value = noteTitle,
                    onValueChange = { noteTitle = it },
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.title),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Black,
                        backgroundColor = Color.White,
                        cursorColor = Color.Gray,
                        focusedIndicatorColor = Green800,
                        unfocusedIndicatorColor = Green800
                    ),
                    textStyle = TextStyle(fontSize = 24.sp)
                )
                TextField(
                    value = noteDescription,
                    onValueChange = { noteDescription = it },
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.note_description),
                            fontSize = 24.sp,
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults
                        .textFieldColors(
                            textColor = Color.Black,
                            backgroundColor = Color.White,
                            focusedLabelColor = Color.White,
                            disabledLabelColor = Color.White,
                            cursorColor = Color.Gray,
                            focusedIndicatorColor = Color.White,
                            unfocusedIndicatorColor = Color.White
                        ),
                    textStyle = TextStyle(fontSize = 18.sp)
                )
            }

        }
    )
}

//@Preview(showBackground = true)
//@Composable
//fun AddNoteScreenPrev() {
//    val context = LocalContext.current
//    val nViewModel: NotesViewModel =
//        viewModel(factory = NotesViewModelFactory(context.applicationContext as Application))
//    val navController = rememberNavController()
//    AddNoteScreen(navController, nViewModel)
//}