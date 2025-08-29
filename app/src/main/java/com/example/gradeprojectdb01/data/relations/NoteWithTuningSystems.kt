package com.example.gradeprojectdb01.data.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.gradeprojectdb01.data.entities.Note
import com.example.gradeprojectdb01.data.entities.TuningSystem
import com.example.gradeprojectdb01.data.entities.TuningSystemNote

data class NoteWithTuningSystems (
    @Embedded val note: Note,
    @Relation (
        parentColumn = "noteId",
        entityColumn = "tunSysId",
        associateBy = Junction (TuningSystemNote::class)
    )
    val tuningSystems: List <TuningSystem>
)