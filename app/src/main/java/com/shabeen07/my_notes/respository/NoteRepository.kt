package com.shabeen07.my_notes.respository

import androidx.annotation.WorkerThread
import com.shabeen07.my_notes.models.NoteDto
import com.shabeen07.my_notes.respository.database.dao.NoteDao
import kotlinx.coroutines.flow.Flow

class NoteRepository(private val noteDao: NoteDao) {


    @WorkerThread
    suspend fun insert(note: NoteDto) {
        noteDao.insert(note)
    }

    @WorkerThread
    suspend fun updateNote(note: NoteDto) {
        noteDao.updateNote(note)
    }

    fun getAllNotes(): Flow<List<NoteDto>> {
        return noteDao.getAllNotes()
    }

    fun getNoteById(noteId: Int): Flow<NoteDto> {
        return noteDao.getNoteById(noteId)
    }

}