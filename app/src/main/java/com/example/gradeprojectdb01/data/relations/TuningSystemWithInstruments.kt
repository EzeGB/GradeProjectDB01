package com.example.gradeprojectdb01.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.gradeprojectdb01.data.entities.Instrument
import com.example.gradeprojectdb01.data.entities.TuningSystem

data class TuningSystemWithInstruments (
    @Embedded val tuningSystem: TuningSystem,
    @Relation (
        parentColumn = "tunSysId",
        entityColumn = "tunSysId",
    )
    val instruments: List <Instrument>
)