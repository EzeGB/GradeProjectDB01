package com.example.gradeprojectdb01.data.convertersAndEnums

import androidx.room.TypeConverter

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