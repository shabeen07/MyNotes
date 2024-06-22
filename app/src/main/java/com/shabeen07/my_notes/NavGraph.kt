package com.shabeen07.my_notes

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shabeen07.my_notes.models.NoteDto
import com.shabeen07.my_notes.ui.screens.AddNoteScreen
import com.shabeen07.my_notes.ui.screens.NoteListScreen
import com.shabeen07.my_notes.ui.screens.Screens

@Composable
fun SetUpNavGraph(navController: NavHostController, notesList: MutableList<NoteDto>) {
    NavHost(navController = navController, startDestination = Screens.NoteList.route) {
        composable(
            route = Screens.NoteList.route
        ){
            NoteListScreen(navController, notesList)
        }
        composable(
            route = Screens.AddNotes.route
        ){
            AddNoteScreen(navController, notesList)
        }
    }
}