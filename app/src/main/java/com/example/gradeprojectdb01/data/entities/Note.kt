package com.example.gradeprojectdb01.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey (autoGenerate = true)
    val noteId: Long,
    val frequency: Double,
    val octave: Int
)