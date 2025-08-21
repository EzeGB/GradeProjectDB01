package com.example.gradeprojectdb01.data.convertersAndEnums

import androidx.room.TypeConverter

class TunSysParamTypeConverter {
    @TypeConverter
    fun fromParamValType(paramValType: ParamValType): String{
        return paramValType.name
    }

    @TypeConverter
    fun toParamValType(paramValTypeString: String): ParamValType {
        return ParamValType.valueOf(paramValTypeString)
    }
}

enum class ParamValType {INT, DOUBLE, STRING}