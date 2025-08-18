package com.example.gradeprojectdb01.data.converters

import androidx.room.TypeConverter
import com.example.gradeprojectdb01.data.entities.ParamValType

class TunSysParamTypeConverter {
    @TypeConverter
    fun fromParamValType(value: ParamValType): String{
        return value.name
    }

    @TypeConverter
    fun toParamValType(value: String): ParamValType {
        return ParamValType.valueOf(String())
    }
}