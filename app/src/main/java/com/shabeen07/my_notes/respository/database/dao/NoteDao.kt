package com.shabeen07.my_notes.respository.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.shabeen07.my_notes.models.NoteDto
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert
    suspend fun insert(note: NoteDto)

    @Update
    suspend fun updateNote(note: NoteDto)

    @Query("SELECT * FROM notes ORDER BY createdAt DESC")
    fun getAllNotes(): Flow<List<NoteDto>>

    @Query("SELECT * FROM notes WHERE noteId = :noteId")
    fun getNoteById(noteId: Int): Flow<NoteDto>

    @Query("DELETE FROM notes WHERE noteId = :noteId")
    fun deleteNote(noteId: Int)

    @Query("UPDATE notes SET note = :note WHERE noteId = :noteId")
    fun updateNote(noteId: Int, note: String)

}