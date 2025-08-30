package com.example.gradeprojectdb01.data.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.gradeprojectdb01.data.entities.Note
import com.example.gradeprojectdb01.data.entities.TuningSystem
import com.example.gradeprojectdb01.data.entities.TuningSystemNote

data class TuningSystemWithNotes (
    @Embedded val tuningSystem: TuningSystem,
    @Relation (
        parentColumn = "tunSysId",
        entityColumn = "noteId",
        associateBy = Junction(TuningSystemNote::class)
    )
    val notes: List <Note>
)