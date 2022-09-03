package com.example.mynotes.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.example.mynotes.NotesViewModel
import com.example.mynotes.model.Category
import com.example.mynotes.navigation.NotesNavRoute
import com.example.mynotes.ui.theme.Green800
import com.example.mynotes.ui.theme.GreenDark

@Composable
fun DialogAddCategory(viewModel: NotesViewModel, setShowDialog: (Boolean) -> Unit) {
    var nameCategory by remember { mutableStateOf("") }


    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Surface(
            color = Color.White,
            modifier = Modifier.border(
                width = 4.dp,
                color = Green800
            )
    ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = nameCategory,
                    label = {
                        Text(
                            text = "Folder name",
                            fontSize = 18.sp
                            )},
                    onValueChange = {
                        nameCategory = it
                    },
                    colors = TextFieldDefaults
                        .textFieldColors(
                            textColor = Color.Black,
                            backgroundColor = Color.White,
                            focusedIndicatorColor = GreenDark,
                            unfocusedIndicatorColor = GreenDark,
                            focusedLabelColor = Color.White,
                            cursorColor = Color.Gray
                        ),
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 18.sp
                    )

                )
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 32.dp, 16.dp, 16.dp)
                    ) {
                    Text(
                        text = "Cancel",
                        color = GreenDark,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(end = 32.dp)
                            .clickable {
                                setShowDialog(false)
                            }
                    )
                    Text(
                        text = "OK",
                        color = GreenDark,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable {
                            viewModel.createCategory(Category(nameCategory = nameCategory)){
                                setShowDialog(false)
                            }
                        }
                    )
                }
            }
        }
    }
}

