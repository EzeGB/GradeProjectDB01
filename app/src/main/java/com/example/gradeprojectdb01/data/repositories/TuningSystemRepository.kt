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

class TuningSystemRepository (private val tuningSystemDao: TuningSystemDao,
    private val tunSysParameterDao: TunSysParameterDao,
    private val noteDao: NoteDao,
    private val tunSysNoteCrossRefDao: TuningSystemNoteCrossRefDao){

    suspend fun insertTunSys(tuningSystem: TuningSystem,
                             tunSysParams: List<TunSysParameter>){
        val tunSysId = tuningSystemDao.insertTuningSystem(tuningSystem)
        tunSysParams.forEach {
            it.tunSysId = tunSysId
            // TODO it.valueType = inferValueType(it.value)
            tunSysParameterDao.insertTunSysParameter(it)
        }
        val notes = generateNotes(tuningSystemDao.getTuningSystemWithParameters(tunSysId))
        noteDao.insertAllNotes(notes)
        notes.forEach {
            val reference = TuningSystemNoteCrossRef(tunSysId,it.noteId)
            tunSysNoteCrossRefDao.insertTunSysNoteCrossRef(reference)
        }
    }

    private fun generateNotes(tuningSystem: TuningSystemWithParameters?): List<Note>{
        //TODO
        return listOf(
            Note(0L, 440.0, "A", "natural", 4, 1.0),
            Note(1L, 493.88, "B", "natural", 4, 1.3)
        )
    }
}