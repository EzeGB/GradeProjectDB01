package com.example.gradeprojectdb01.data.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.gradeprojectdb01.data.entities.Instrument
import com.example.gradeprojectdb01.data.entities.InstrumentNoteCrossRef
import com.example.gradeprojectdb01.data.entities.Note
import com.example.gradeprojectdb01.data.entities.TunSysParameter
import com.example.gradeprojectdb01.data.entities.TuningSystem
import com.example.gradeprojectdb01.data.entities.TuningSystemNoteCrossRef

data class NoteWithInstruments (
    @Embedded val note: Note,
    @Relation (
        parentColumn = "noteId",
        entityColumn = "instrumentId",
        associateBy = Junction(InstrumentNoteCrossRef::class)
    )
    val instruments: List<Instrument>
)