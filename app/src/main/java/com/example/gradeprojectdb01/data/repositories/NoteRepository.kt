package com.example.gradeprojectdb01.data.repositories

import com.example.gradeprojectdb01.data.daos.NoteDao
import com.example.gradeprojectdb01.data.entities.Note

class NoteRepository (private val noteDao: NoteDao){

    suspend fun insertNote (note: Note):Long{
        return noteDao.insertNote(note)
    }

    suspend fun insertAllNotes(notes: List<Note>):List<Long>{
        return noteDao.insertAllNotes(notes)
    }

    suspend fun insertMultipleNotes(notes: List<Note>){
        noteDao.insertAllNotes(notes)
    }
}