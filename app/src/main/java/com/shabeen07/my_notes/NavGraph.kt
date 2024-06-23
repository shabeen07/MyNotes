package com.shabeen07.my_notes

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.shabeen07.my_notes.ui.screens.AddNoteScreen
import com.shabeen07.my_notes.ui.screens.NoteListScreen
import com.shabeen07.my_notes.ui.screens.Screens
import com.shabeen07.my_notes.viewmodels.NoteViewModel

@Composable
fun SetUpNavGraph(
    navController: NavHostController,
    noteViewModel: NoteViewModel
) {
    NavHost(navController = navController, startDestination = Screens.NoteList.route) {
        composable(
            route = Screens.NoteList.route,
        ) {
            NoteListScreen(navController, noteViewModel)
        }
        composable(
            route = Screens.AddNotes.route,
            arguments = listOf(
                navArgument("noteId") {
                    type = NavType.IntType
                    defaultValue = 0
                    navArgument("note") {
                        type = NavType.StringType
                        defaultValue = ""
                    }
                })
        ) { backStackEntry ->
            val noteId = backStackEntry.arguments?.getInt("noteId") ?: 0
            val note = backStackEntry.arguments?.getString("note") ?: ""
            AddNoteScreen(navController, noteViewModel, noteId, note)
        }
    }
}