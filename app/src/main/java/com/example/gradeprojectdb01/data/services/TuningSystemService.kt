package com.example.gradeprojectdb01.data.services

import com.example.gradeprojectdb01.data.entities.Note
import com.example.gradeprojectdb01.data.entities.TunSysParameter
import com.example.gradeprojectdb01.data.entities.TuningSystem
import com.example.gradeprojectdb01.data.entities.TuningSystemNoteCrossRef
import com.example.gradeprojectdb01.data.relations.TuningSystemWithParameters
import com.example.gradeprojectdb01.data.repositories.NoteRepository
import com.example.gradeprojectdb01.data.repositories.TunSysParameterRepository
import com.example.gradeprojectdb01.data.repositories.TuningSystemNoteCrossRefRepository
import com.example.gradeprojectdb01.data.repositories.TuningSystemRepository

public class TuningSystemService (
    private val tunSysRepo: TuningSystemRepository,
    private val tunSysParamRepo: TunSysParameterRepository,
    private val noteRepo: NoteRepository,
    private val tunSysNoteCrossRefRepo: TuningSystemNoteCrossRefRepository
) {
    suspend fun createTuningSystem(tuningSystem: TuningSystem, tunSysParams:List<TunSysParameter>) {
        val tunSysId = tunSysRepo.insertTunSys(tuningSystem)
        tunSysParams.forEach {
            it.tunSysId = tunSysId
            // TODO it.valueType = inferValueType(it.value)
            tunSysParamRepo.insertTunSysParam(it)
        }
        val notes = generateNotes(tunSysRepo.getTunSysWithParams(tunSysId))
        val notesIds = noteRepo.insertAllNotes(notes)
        notesIds.forEach {
            val reference = TuningSystemNoteCrossRef(tunSysId, it)
            tunSysNoteCrossRefRepo.insertTunSysNoteCrossRef(reference)
        }
    }

    private fun generateNotes(tuningSystem: TuningSystemWithParameters?):List<Note>

    {
        //TODO
        return listOf(
            Note(0L, 440.0, "A", "natural", 4, 1.0),
            Note(1L, 493.88, "B", "natural", 4, 1.3)
        )
    }
}