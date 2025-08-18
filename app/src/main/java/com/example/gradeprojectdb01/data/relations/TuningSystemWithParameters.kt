package com.example.gradeprojectdb01.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.gradeprojectdb01.data.entities.TunSysParameter
import com.example.gradeprojectdb01.data.entities.TuningSystem

data class TuningSystemWithParameters (
    @Embedded val tuningSystem: TuningSystem,
    @Relation (
        parentColumn = "tunSysId",
        entityColumn = "tunSysId"
    )
    val tunSysParams: List <TunSysParameter>
)