package com.example.gradeprojectdb01.data.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.gradeprojectdb01.data.entities.Note
import com.example.gradeprojectdb01.data.entities.TunSysParameter
import com.example.gradeprojectdb01.data.entities.TuningSystem
import com.example.gradeprojectdb01.data.entities.TuningSystemNoteCrossRef

data class TuningSystemWithNotes (
    @Embedded val tuningSystem: TuningSystem,
    @Relation (
        parentColumn = "tunSysId",
        entityColumn = "noteId",
        associateBy = Junction(TuningSystemNoteCrossRef::class)
    )
    val notes: List <Note>
)