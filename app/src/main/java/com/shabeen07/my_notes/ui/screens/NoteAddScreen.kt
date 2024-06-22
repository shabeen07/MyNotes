package com.shabeen07.my_notes.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.shabeen07.my_notes.R
import com.shabeen07.my_notes.models.NoteDto
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddNoteScreen(navController: NavHostController, notesList: MutableList<NoteDto>) {
    var note by remember { mutableStateOf("") }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = {
                Text(text = "Add Note")
            }, actions = {
                IconButton(
                    modifier = Modifier
                        .padding(16.dp, 0.dp),
                    onClick = {
                        saveNote(note, notesList)
                        navController.popBackStack()
                    },
                    content = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_save_24),
                            contentDescription = "Save",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    },
                )
            }, navigationIcon = {
                IconButton(
                    modifier = Modifier.padding(8.dp, 0.dp),
                    onClick = {
                        navController.popBackStack()
                    },
                    content = {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Back",
                        )
                    },
                )
            })
        },
        /*floatingActionButton = {
            ExtendedFloatingActionButton(onClick = {
                saveNote(note, notesList)
                navController.popBackStack()
            }, text = {
                Text(text = "SAVE")
            }, icon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_save_24),
                    contentDescription = "Save"
                )
            })
        }*/
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                value = note,
                onValueChange = { note = it },
                label = { Text(text = "Type something...") })
        }
    }
}

fun saveNote(note: String, notesList: MutableList<NoteDto>) {
    notesList.add(
        NoteDto(
            Random.nextInt(),
            note,
            System.currentTimeMillis()
        )
    )
}
