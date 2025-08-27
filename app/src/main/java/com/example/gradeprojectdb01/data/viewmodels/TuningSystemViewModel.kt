package com.example.gradeprojectdb01.data.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.gradeprojectdb01.data.MainDatabase
import com.example.gradeprojectdb01.data.entities.TunSysParameter
import com.example.gradeprojectdb01.data.entities.TuningSystem
import com.example.gradeprojectdb01.data.repositories.TuningSystemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TuningSystemViewModel (application: Application): AndroidViewModel(application){
    val tuningSystemWriteRepository: TuningSystemRepository

    init{
        val db = MainDatabase.getDatabaseInstance(getApplication())
        val tunSysDao = db.tuningSystemDao
        val tunSysParamDao = db.tunSysParameterDao
        val noteDao = db.noteDao
        val tunSysNoteCrossRefDao = db.tuningSystemNoteDao
        tuningSystemWriteRepository = TuningSystemRepository(tunSysDao,
            tunSysParamDao, noteDao, tunSysNoteCrossRefDao)
    }

    fun insertTuningSystem(tuningSystem: TuningSystem, parameters: List<TunSysParameter>){
        viewModelScope.launch(Dispatchers.IO) {
            tuningSystemWriteRepository.insertTunSys(tuningSystem,parameters)
        }
    }
}