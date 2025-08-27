package com.example.gradeprojectdb01.data.repositories

import com.example.gradeprojectdb01.data.daos.NoteDao
import com.example.gradeprojectdb01.data.entities.Note

class NoteRepository (private val noteDao: NoteDao){

    suspend fun insertNote (note: Note){
        noteDao.insertNote(note)
    }

    suspend fun insertMultipleNotes(notes: List<Note>){
        noteDao.insertAllNotes(notes)
    }
}