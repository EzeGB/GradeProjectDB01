package com.example.gradeprojectdb01.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity (foreignKeys = [ForeignKey(entity = TuningSystem::class,
    parentColumns = arrayOf("tunSysId"),
    childColumns = arrayOf("tunSysId"),
    onDelete = ForeignKey.CASCADE)],
    indices = [androidx.room.Index(value = ["tunSysId"])])

data class TunSysParameter (
    @PrimaryKey (autoGenerate = true)
    val tunSysParamId: Int,
    val tunSysId: Int,
    val valueType : ParamValType,
    val valueName: String,
    val value: String,
)
enum class ParamValType {INT, DOUBLE, STRING}