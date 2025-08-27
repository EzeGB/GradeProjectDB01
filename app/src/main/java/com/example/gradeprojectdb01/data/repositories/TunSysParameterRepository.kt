package com.example.gradeprojectdb01.data.repositories

import com.example.gradeprojectdb01.data.daos.TunSysParameterDao
import com.example.gradeprojectdb01.data.entities.TunSysParameter

class TunSysParameterRepository (private val tunSysParameterDao: TunSysParameterDao){

    suspend fun insertTunSysParam(tunSysParameter: TunSysParameter){
        tunSysParameterDao.insertTunSysParameter(tunSysParameter)
    }
}