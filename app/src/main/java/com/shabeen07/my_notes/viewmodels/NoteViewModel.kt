package com.shabeen07.my_notes.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.shabeen07.my_notes.models.NoteDto
import com.shabeen07.my_notes.respository.NoteRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class NoteViewModel(private val repository: NoteRepository) : ViewModel() {

    val allNotes: LiveData<List<NoteDto>> = repository.getAllNotes().asLiveData()

    fun getNoteById(noteId: Int): LiveData<NoteDto> {
        return repository.getNoteById(noteId).asLiveData()
    }

    fun addNote(noteDto: NoteDto) {
        viewModelScope.launch {
            repository.insert(noteDto)
        }
    }

    fun updateNote(noteDto: NoteDto) {
        viewModelScope.launch {
            repository.updateNote(noteDto)
        }
    }

}