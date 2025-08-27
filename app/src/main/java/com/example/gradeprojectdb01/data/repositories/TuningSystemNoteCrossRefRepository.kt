package com.example.gradeprojectdb01.data.repositories

import com.example.gradeprojectdb01.data.daos.TuningSystemNoteCrossRefDao
import com.example.gradeprojectdb01.data.entities.TuningSystemNoteCrossRef

class TuningSystemNoteCrossRefRepository (private val tunSysNoteCrossRefDao: TuningSystemNoteCrossRefDao){
    suspend fun insertTunSysNoteCrossRefDao(tuningSystemNoteCrossRef: TuningSystemNoteCrossRef){
        tunSysNoteCrossRefDao.insertTunSysNoteCrossRef(tuningSystemNoteCrossRef)
    }
}