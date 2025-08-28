package com.example.gradeprojectdb01.data.repositories

import com.example.gradeprojectdb01.data.daos.NoteDao
import com.example.gradeprojectdb01.data.daos.TunSysParameterDao
import com.example.gradeprojectdb01.data.daos.TuningSystemDao
import com.example.gradeprojectdb01.data.daos.TuningSystemNoteCrossRefDao
import com.example.gradeprojectdb01.data.entities.Note
import com.example.gradeprojectdb01.data.entities.TunSysParameter
import com.example.gradeprojectdb01.data.entities.TuningSystem
import com.example.gradeprojectdb01.data.entities.TuningSystemNoteCrossRef
import com.example.gradeprojectdb01.data.relations.TuningSystemWithParameters

class TuningSystemRepository (private val tuningSystemDao: TuningSystemDao){

    suspend fun insertTunSys(tuningSystem: TuningSystem):Long{
        return tuningSystemDao.insertTuningSystem(tuningSystem)
    }

    suspend fun getTunSysWithParams(tunSysId:Long) =
        tuningSystemDao.getTuningSystemWithParameters(tunSysId)
}