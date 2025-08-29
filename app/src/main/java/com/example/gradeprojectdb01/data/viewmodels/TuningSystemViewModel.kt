package com.example.gradeprojectdb01.data.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.gradeprojectdb01.data.MainDatabase
import com.example.gradeprojectdb01.data.entities.TunSysParameter
import com.example.gradeprojectdb01.data.entities.TuningSystem
import com.example.gradeprojectdb01.data.repositories.NoteRepository
import com.example.gradeprojectdb01.data.repositories.TunSysParameterRepository
import com.example.gradeprojectdb01.data.repositories.TuningSystemNoteRepository
import com.example.gradeprojectdb01.data.repositories.TuningSystemRepository
import com.example.gradeprojectdb01.data.services.TuningSystemService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TuningSystemViewModel (application: Application): AndroidViewModel(application){
    private val tunSysService: TuningSystemService

    init{
        val db = MainDatabase.getDatabaseInstance(getApplication())
        val tunSysDao = db.tuningSystemDao
        val tunSysParamDao = db.tunSysParameterDao
        val noteDao = db.noteDao
        val tunSysNoteCrossRefDao = db.tuningSystemNoteDao
        tunSysService = TuningSystemService(
            TuningSystemRepository(tunSysDao),
            TunSysParameterRepository(tunSysParamDao),
            NoteRepository(noteDao),
            TuningSystemNoteRepository(tunSysNoteCrossRefDao)
        )
    }

    fun insertTuningSystem(tuningSystem: TuningSystem, parameters: List<TunSysParameter>){
        viewModelScope.launch(Dispatchers.IO) {
            tunSysService.createTuningSystem(tuningSystem,parameters)
        }
    }
}