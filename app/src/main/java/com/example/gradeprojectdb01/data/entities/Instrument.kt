package com.example.gradeprojectdb01.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Instrument (
    @PrimaryKey (autoGenerate = true)
    val instrumentId: Long,
    val name: String
)