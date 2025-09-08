package com.example.gradeprojectdb01.data

import com.example.gradeprojectdb01.data.entities.Note

class NotesGenerator {
    fun generateNotes(): List<Note>{
        return listOf(
            Note(0L, 440.0),
            Note(1L, 493.88)
        )
    }
}