package com.example.gradeprojectdb01.data.daos

import androidx.lifecycle.LiveData
import com.example.gradeprojectdb01.data.entities.Note

interface NoteDao {
    suspend fun addNote(note: Note)

    fun readAllNotesLive(): LiveData<List<Note>>

    suspend fun readAllNotes(): List<Note>

    suspend fun updateNote(note: Note)

    suspend fun deleteNote(note: Note)

    suspend fun deleteAllNotes()
}