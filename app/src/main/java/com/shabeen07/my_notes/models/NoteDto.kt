package com.shabeen07.my_notes.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
class NoteDto(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "noteId") val noteId: Int?,
    @ColumnInfo(name = "note") val note: String,
    @ColumnInfo(name = "createdAt") val createdAt: Long
)