package com.example.gradeprojectdb01.data.daos

import androidx.room.Dao
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

@Dao
interface NoteDao {
    //CREATE BLOCK
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note):Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllNotes(notes: List<Note>): List<Long>

    //READ BLOCK
    @Query("SELECT * FROM Note WHERE noteId = :noteId")
    suspend fun getNoteById(noteId: Long): Note?

    @Query("SELECT * FROM Note ORDER BY noteId ASC")
    suspend fun getAllNotes(): List<Note>

    @Query("SELECT * FROM Note WHERE noteId = :noteId")
    fun observeNoteById(noteId: Long): Flow<Note?>

    @Query("SELECT * FROM Note ORDER BY noteId ASC")
    fun observeAllNotes(): Flow<List<Note>>

    //Relations
    @Transaction
    @Query("SELECT * FROM Note WHERE noteId = :noteId")
    suspend fun getNoteWithInstruments(noteId:Long): NoteWithInstruments?

    @Transaction
    @Query("SELECT * FROM Note WHERE noteId = :noteId")
    suspend fun getNoteWithTuningSystems(noteId:Long): NoteWithTuningSystems?

    @Transaction
    @Query("SELECT * FROM Note WHERE noteId = :noteId")
    fun observeNoteWithInstruments(noteId:Long): Flow<NoteWithInstruments?>

    @Transaction
    @Query("SELECT * FROM Note WHERE noteId = :noteId")
    fun observeNoteWithTuningSystems(noteId:Long): Flow<NoteWithTuningSystems?>

    //UPDATE BLOCK
    @Update
    suspend fun updateNote(note: Note)

    @Update
    suspend fun updateNotes(notes: List<Note>)

    @Query("UPDATE Note SET name = :name WHERE noteId = :noteId")
    suspend fun updateNoteName(noteId: Long, name:String)

    @Query("UPDATE Note SET alteration = :alteration WHERE noteId = :noteId")
    suspend fun updateNoteAlteration(noteId: Long, alteration:String)

    //DELETE BLOCK
    @Delete
    suspend fun deleteNote(note: Note)

    @Query("DELETE FROM Note WHERE noteId = :noteId")
    suspend fun deleteNoteById(noteId: Long)

    @Delete
    suspend fun deleteNotes(notes: List<Note>)

    @Query("DELETE FROM Note WHERE noteId IN (:noteIds)")
    suspend fun deleteNotesByIds(noteIds: List<Long>)

    @Query("DELETE FROM Note")
    suspend fun deleteAllNotes()
}