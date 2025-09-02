package com.example.gradeprojectdb01.data.repositories

import com.example.gradeprojectdb01.data.daos.NoteDao
import com.example.gradeprojectdb01.data.entities.Note
import com.example.gradeprojectdb01.data.relations.NoteWithInstruments
import com.example.gradeprojectdb01.data.relations.NoteWithTuningSystems
import kotlinx.coroutines.flow.Flow

class NoteRepository (private val noteDao: NoteDao){

    // CREATE
    suspend fun insertNote(note: Note): Long {
        return noteDao.insertNote(note)
    }

    suspend fun insertAllNotes(notes: List<Note>): List<Long> {
        return noteDao.insertAllNotes(notes)
    }

    // READ
    suspend fun getNoteById(noteId: Long): Note? {
        return noteDao.getNoteById(noteId)
    }

    suspend fun getNoteByFrequency(noteFrequency:Double): Note?{
        return noteDao.getNoteByFrequency(noteFrequency)
    }

    suspend fun getAllNotes(): List<Note> {
        return noteDao.getAllNotes()
    }

    fun observeNoteById(noteId: Long): Flow<Note?> {
        return noteDao.observeNoteById(noteId)
    }

    fun observeAllNotes(): Flow<List<Note>> {
        return noteDao.observeAllNotes()
    }

    // RELATIONS
    suspend fun getNoteWithInstruments(noteId: Long): NoteWithInstruments? {
        return noteDao.getNoteWithInstruments(noteId)
    }

    suspend fun getNoteWithTuningSystems(noteId: Long): NoteWithTuningSystems? {
        return noteDao.getNoteWithTuningSystems(noteId)
    }

    fun observeNoteWithInstruments(noteId: Long): Flow<NoteWithInstruments?> {
        return noteDao.observeNoteWithInstruments(noteId)
    }

    fun observeNoteWithTuningSystems(noteId: Long): Flow<NoteWithTuningSystems?> {
        return noteDao.observeNoteWithTuningSystems(noteId)
    }

    // UPDATE
    suspend fun updateNote(note: Note) {
        noteDao.updateNote(note)
    }

    suspend fun updateNotes(notes: List<Note>) {
        noteDao.updateNotes(notes)
    }

    // DELETE
    suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }

    suspend fun deleteNoteById(noteId: Long) {
        noteDao.deleteNoteById(noteId)
    }

    suspend fun deleteNotes(notes: List<Note>) {
        noteDao.deleteNotes(notes)
    }

    suspend fun deleteNotesByIds(noteIds: List<Long>) {
        noteDao.deleteNotesByIds(noteIds)
    }

    suspend fun deleteAllNotes() {
        noteDao.deleteAllNotes()
    }
}