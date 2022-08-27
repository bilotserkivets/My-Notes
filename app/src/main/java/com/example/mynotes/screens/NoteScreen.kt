package com.example.mynotes.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mynotes.R
import com.example.mynotes.navigation.NotesNavRoute
import com.example.mynotes.ui.theme.Green800
import kotlinx.coroutines.launch

@Composable
fun NoteScreen(navController: NavHostController) {
    var noteTitle by remember { mutableStateOf("") }
    var noteD by remember { mutableStateOf("") }
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
                TextField(
                    value = noteTitle,
                    onValueChange = { noteTitle = it },
                    placeholder = { Text(
                        text = stringResource(id = R.string.title),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                        ) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(textColor = Color.Black, backgroundColor = Color.White)
                )

                TextField(
                    value = noteTitle,
                    onValueChange = { noteTitle = it },
                    placeholder = { Text(
                        text = stringResource(id = R.string.note),
                        fontSize = 24.sp,
                    ) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults
                        .textFieldColors(
                            textColor = Color.Black,
                            backgroundColor = Color.White,
                            focusedLabelColor = Color.White,
                            disabledLabelColor = Color.White
                            )
                )
            }

        }
    )
}

@Preview(showBackground = true)
@Composable
fun NoteScreenPrev() {
    val navController = rememberNavController()
    NoteScreen(navController)
}