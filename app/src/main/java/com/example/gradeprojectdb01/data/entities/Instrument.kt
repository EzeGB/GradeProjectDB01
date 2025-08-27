package com.example.gradeprojectdb01.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = TuningSystem::class,
    parentColumns = arrayOf("tunSysId"),
    childColumns = arrayOf("tunSysId"),
    onDelete = ForeignKey.CASCADE)])

data class Instrument (
    @PrimaryKey (autoGenerate = true)
    val instrumentId: Long,
    var tunSysId: Long,
    val name: String
)