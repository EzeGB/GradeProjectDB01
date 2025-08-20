package com.example.gradeprojectdb01.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity (primaryKeys = ["tunSysId","noteId"],

    foreignKeys = [ForeignKey(entity = TuningSystem::class,
        parentColumns = arrayOf("tunSysId"),
        childColumns = arrayOf("tunSysId"),
        onDelete = ForeignKey.CASCADE),

        ForeignKey(entity = Note::class,
            parentColumns = arrayOf("noteId"),
            childColumns = arrayOf("noteId"),
            onDelete = ForeignKey.CASCADE)],

    indices = [Index("tunSysId"), Index("noteId")]
)

data class TuningSystemNoteCrossRef (
    val tunSysId: Long,
    val noteId: Long
)