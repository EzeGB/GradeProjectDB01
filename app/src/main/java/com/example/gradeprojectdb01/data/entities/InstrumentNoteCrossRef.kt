package com.example.gradeprojectdb01.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity (primaryKeys = ["instrumentId","noteId"],

    foreignKeys = [ForeignKey(entity = Instrument::class,
        parentColumns = arrayOf("instrumentId"),
        childColumns = arrayOf("instrumentId"),
        onDelete = ForeignKey.CASCADE),

        ForeignKey(entity = Note::class,
            parentColumns = arrayOf("noteId"),
            childColumns = arrayOf("noteId"),
            onDelete = ForeignKey.CASCADE)],

    indices = [Index("instrumentId"), Index("noteId")]
    )
data class InstrumentNoteCrossRef (
    var instrumentId: Long,
    var noteId: Long
)