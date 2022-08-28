package com.example.mynotes.screens

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
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
import com.example.mynotes.ui.theme.BottomSheetBackground
import com.example.mynotes.ui.theme.DividerInMenu
import com.example.mynotes.ui.theme.Green800
import com.example.mynotes.ui.theme.GreenDark
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen(navController: NavHostController, viewModel: NotesViewModel) {

    val coroutineScope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    var expanded by remember { mutableStateOf(false) }

    val notes = viewModel.getAllNotes().observeAsState(listOf()).value

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetElevation = 4.dp,
        sheetBackgroundColor = BottomSheetBackground,
        sheetShape = RoundedCornerShape(8.dp),
        sheetContent = {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                    ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(painterResource(
                            id = R.drawable.ic_settings),
                            contentDescription = stringResource(id = R.string.settings_button),
                            modifier = Modifier.size(64.dp),
                            tint = GreenDark
                        )
                        Text(
                            text = stringResource(id = R.string.settings),
                            fontSize = 14.sp,
                            color = Color.Black
                            )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(painterResource(
                            id = R.drawable.ic_delete),
                            contentDescription = stringResource(id = R.string.delete_button),
                            modifier = Modifier.size(64.dp),
                            tint = GreenDark
                        )
                        Text(
                            text = stringResource(id = R.string.delete),
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(painterResource(
                            id = R.drawable.ic_share),
                            contentDescription = stringResource(id = R.string.share_button),
                            modifier = Modifier.size(64.dp),
                            tint = GreenDark
                        )
                        Text(
                            text = stringResource(id = R.string.share),
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(painterResource(
                            id = R.drawable.ic_settings),
                            contentDescription = stringResource(id = R.string.settings_button),
                            modifier = Modifier.size(64.dp),
                            tint = GreenDark
                        )
                        Text(
                            text = stringResource(id = R.string.settings),
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(painterResource(
                            id = R.drawable.ic_delete),
                            contentDescription = stringResource(id = R.string.delete_button),
                            modifier = Modifier.size(64.dp),
                            tint = GreenDark
                        )
                        Text(
                            text = stringResource(id = R.string.delete),
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(painterResource(
                            id = R.drawable.ic_share),
                            contentDescription = stringResource(id = R.string.share_button),
                            modifier = Modifier.size(64.dp),
                            tint = GreenDark
                        )
                        Text(
                            text = stringResource(id = R.string.share),
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                    }
                }

            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = stringResource(R.string.notes))
                    },
                    contentColor = Color.White,
                    backgroundColor = Green800,
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                coroutineScope.launch {
                                    bottomSheetState.show()
                                }
                            }) {
                            Icon(
                                imageVector = Icons.Outlined.Menu,
                                contentDescription = stringResource(id = R.string.menu),
                                modifier = Modifier.size(40.dp)
                            )
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = {
                                /*TODO*/
                            }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_search),
                                contentDescription = stringResource(id = R.string.search),
                                modifier = Modifier.size(40.dp),
                                tint = Color.White
                            )
                        }
                        IconButton(
                            onClick = {
                                /*TODO*/
                            }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_sort),
                                contentDescription = stringResource(id = R.string.sort),
                                modifier = Modifier.size(40.dp),
                                tint = Color.White
                            )
                        }
                        IconButton(
                            onClick = {
                                expanded = !expanded
                            }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_add),
                                contentDescription = stringResource(id = R.string.add),
                                modifier = Modifier.size(40.dp),
                                tint = Color.White
                            )
                        }
                        DropdownMenu(
                            modifier = Modifier
                                .width(300.dp)
                                .padding(horizontal = 4.dp),
                            expanded = expanded,
                            onDismissRequest = { expanded = false }) {
                            DropdownMenuItem(
                                onClick = {
                                    navController.navigate(NotesNavRoute.NoteScreen.route)
                                }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_note),
                                    contentDescription = stringResource(id = R.string.note_image),
                                    modifier = Modifier
                                        .padding(vertical = 8.dp)
                                        .size(40.dp),
                                    tint = Green800,
                                )
                                Text(
                                    text = stringResource(id = R.string.note),
                                    modifier = Modifier.padding(horizontal = 16.dp)
                                    )
                            }

                            Divider(color = DividerInMenu, thickness = 2.dp)
                            DropdownMenuItem(
                                onClick = {
                                    navController.navigate(NotesNavRoute.ChecklistScreen.route)
                                }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_checklist),
                                    contentDescription = stringResource(id = R.string.checklist_image),
                                    modifier = Modifier
                                        .padding(vertical = 8.dp)
                                        .size(40.dp),
                                    tint = Green800
                                )
                                Text(
                                    text = stringResource(id = R.string.checklist),
                                    modifier = Modifier.padding(horizontal = 16.dp)
                                )
                            }
                            Divider(color = DividerInMenu, thickness = 2.dp)
                            DropdownMenuItem(
                                onClick = {
                                    /*TODO*/
                                }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_folder),
                                    contentDescription = stringResource(id = R.string.folder_image),
                                    modifier = Modifier
                                        .padding(vertical = 8.dp)
                                        .size(40.dp),
                                    tint = Green800
                                )
                                Text(
                                    text = stringResource(id = R.string.folder),
                                    modifier = Modifier.padding(horizontal = 16.dp)
                                )
                            }
                            Divider(color = DividerInMenu, thickness = 2.dp)
                        }
                    }
                )
            }
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 16.dp)) {
                //CategoryItem()
                NoteItem(notes = notes)
                //NoteCheckItem()
            }
        }
    }

}

@Composable
fun CategoryItem() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_folder),
            contentDescription = stringResource(id = R.string.folder),
            modifier = Modifier.size(56.dp),
            tint = Green800
        )
        Text(
            text = "Products",
            fontSize = 24.sp,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
    Divider(color = Green800, thickness = 2.dp)
}

@Composable
fun NoteItem(notes: List<Note>) {
    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)) {
        items(notes) { note ->
            Text(
                text = note.noteTitle,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = note.noteDescription,
                fontSize = 16.sp,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                ,
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = note.createDataNote,
                    fontSize = 12.sp
                )
            }
            Divider(color = Green800, thickness = 2.dp)
        }

    }

}

@Composable
fun NoteCheckItem() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)
    ) {
        Text(
            text = "Check title",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "* Bananas",
            fontSize = 16.sp,
        )
        Text(
            text = "* Bananas",
            fontSize = 16.sp,
        )
        Text(
            text = "* Bananas",
            fontSize = 16.sp,
            overflow = TextOverflow.Ellipsis
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = "25.08.2022",
                fontSize = 12.sp
            )
        }

    }
    Divider(color = Green800, thickness = 2.dp)

}

@Preview(showBackground = true)
@Composable
fun MainScreenPrev() {
    val context = LocalContext.current
    val nViewModel: NotesViewModel =
        viewModel(factory = NotesViewModelFactory(context.applicationContext as Application))
    val navController = rememberNavController()
    MainScreen(navController, nViewModel)
}