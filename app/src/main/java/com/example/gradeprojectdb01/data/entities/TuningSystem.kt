package com.example.gradeprojectdb01.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TuningSystem(
    @PrimaryKey (autoGenerate = true)
    val tunSysId: Long,
    val algorithm: String
)