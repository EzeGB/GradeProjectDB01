package com.example.gradeprojectdb01.data.daos

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.gradeprojectdb01.data.entities.Note
import com.example.gradeprojectdb01.data.relations.NoteWithInstruments
import com.example.gradeprojectdb01.data.relations.NoteWithTuningSystems
import kotlinx.coroutines.flow.Flow

interface NoteDao {
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun addNote(note: Note)

    @Query("SELECT * FROM Note ORDER BY noteId ASC")
    fun observeAllNotes(): Flow<List<Note>>

    @Query("SELECT * FROM Note ORDER BY noteId ASC")
    suspend fun getAllNotesOnce(): List<Note>

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("DELETE FROM Note")
    suspend fun deleteAllNotes()

    @Transaction
    @Query("SELECT * FROM Note WHERE noteId = :noteId")
    suspend fun getNoteWithInstrumentsOnce(noteId:Int): List<NoteWithInstruments>

    @Transaction
    @Query("SELECT * FROM Note WHERE noteId = :noteId")
    suspend fun getNoteWithTuningSystemsOnce(noteId:Int): List<NoteWithTuningSystems>

    @Transaction
    @Query("SELECT * FROM Note WHERE noteId = :noteId")
    fun observeNoteWithInstruments(noteId:Int): Flow<List<NoteWithInstruments>>

    @Transaction
    @Query("SELECT * FROM Note WHERE noteId = :noteId")
    fun observeNoteWithTuningSystems(noteId:Int): Flow<List<NoteWithTuningSystems>>
}