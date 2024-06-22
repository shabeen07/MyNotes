package com.shabeen07.my_notes.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.shabeen07.my_notes.models.NoteDto
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteListScreen(navController: NavHostController, notesList: MutableList<NoteDto>) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = {
                Text(text = "My Notes", textAlign = TextAlign.Center)
            })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Screens.AddNotes.route)
            }) {
                Icon(Icons.Default.Edit, contentDescription = "Add Note")
            }
        }
    ) { innerPadding ->
        LazyVerticalStaggeredGrid(
            modifier = Modifier.padding(innerPadding),
            columns = StaggeredGridCells.Fixed(2),
            verticalItemSpacing = 4.dp,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            items(notesList) { note ->
                NoteItem(note = note)
            }
        }
    }
}

@Composable
fun NoteItem(note: NoteDto) {
    val simpleDateFormat = SimpleDateFormat("dd-MM-yyyy hh:mm:ss", Locale.getDefault())
    val formattedDate = simpleDateFormat.format(Date(note.createdAt))
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                //TODO
            }
            .clipToBounds()
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = note.note, style = MaterialTheme.typography.titleSmall.copy(
                    color = MaterialTheme.colorScheme.onSurface
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = formattedDate, style = MaterialTheme.typography.labelSmall.copy(
                    color = MaterialTheme.colorScheme.outline
                )
            )
        }
    }

}
