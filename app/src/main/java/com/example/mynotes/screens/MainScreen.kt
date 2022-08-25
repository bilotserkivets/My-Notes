package com.example.mynotes.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynotes.R
import com.example.mynotes.ui.theme.Green800


@Composable
fun MainScreen() {
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
                       /*TODO*/
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
                            /*TODO*/
                        }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_add),
                            contentDescription = stringResource(id = R.string.add),
                            modifier = Modifier.size(40.dp),
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 16.dp)) {
            CategoryItem()
            NoteItem()
            NoteCheckItem()
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
fun NoteItem() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)
    ) {
        Text(
            text = "Title",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
            )
        Text(
            text = "Lorem ipsum lorem ipsum text How are you. Hello world Lorem ipsum lorem ipsum text How are you. Hello world Lorem ipsum lorem ipsum text How are you. Hello world",
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
                text = "25.08.2022",
                fontSize = 12.sp
                )
        }
        Divider(color = Green800, thickness = 2.dp)
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
    MainScreen()
}