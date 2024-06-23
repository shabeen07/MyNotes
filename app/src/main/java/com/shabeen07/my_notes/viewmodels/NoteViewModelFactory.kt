package com.shabeen07.my_notes.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shabeen07.my_notes.respository.NoteRepository

class NoteViewModelFactory(private val noteRepository: NoteRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        NoteViewModel(noteRepository) as T

}