package com.example.gradeprojectdb01.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.gradeprojectdb01.data.convertersAndEnums.ParamValType

@Entity (foreignKeys = [ForeignKey(entity = TuningSystem::class,
    parentColumns = arrayOf("tunSysId"),
    childColumns = arrayOf("tunSysId"),
    onDelete = ForeignKey.CASCADE)],
    indices = [Index("tunSysId")])

data class TunSysParameter (
    @PrimaryKey (autoGenerate = true)
    val tunSysParamId: Long,
    var tunSysId: Long,
    var valueType : ParamValType,
    val valueName: String,
    val value: String
)