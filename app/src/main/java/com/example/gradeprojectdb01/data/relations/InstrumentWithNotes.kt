package com.example.gradeprojectdb01.data.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.gradeprojectdb01.data.entities.Instrument
import com.example.gradeprojectdb01.data.entities.InstrumentNote
import com.example.gradeprojectdb01.data.entities.Note

data class InstrumentWithNotes (
    @Embedded val instrument: Instrument,
    @Relation (
        parentColumn = "instrumentId",
        entityColumn = "noteId",
        associateBy = Junction(InstrumentNote::class)
    )
    val notes: List <Note>
)