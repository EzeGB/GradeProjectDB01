package com.example.gradeprojectdb01.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey (autoGenerate = true)
    val noteId: Long,
    val frequency: Double,
    val name: String,
    val alteration: String,
    val octave: Int,
    val relationToReference: Double
)