package com.shabeen07.my_notes.ui.screens

sealed class Screens(val route: String) {
    data object NoteList : Screens(route = "note_list_screen")
    data object AddNotes : Screens(route = "add_notes_screen")
}