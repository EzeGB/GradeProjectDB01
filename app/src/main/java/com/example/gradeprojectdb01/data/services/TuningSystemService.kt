package com.example.gradeprojectdb01.data.services

import com.example.gradeprojectdb01.data.entities.Note
import com.example.gradeprojectdb01.data.entities.TunSysParameter
import com.example.gradeprojectdb01.data.entities.TuningSystem
import com.example.gradeprojectdb01.data.entities.TuningSystemNote
import com.example.gradeprojectdb01.data.relations.TuningSystemWithParameters
import com.example.gradeprojectdb01.data.repositories.NoteRepository
import com.example.gradeprojectdb01.data.repositories.TunSysParameterRepository
import com.example.gradeprojectdb01.data.repositories.TuningSystemNoteRepository
import com.example.gradeprojectdb01.data.repositories.TuningSystemRepository

class TuningSystemService (
    private val tunSysRepo: TuningSystemRepository,
    private val tunSysParamRepo: TunSysParameterRepository,
    private val noteRepo: NoteRepository,
    private val tunSysNoteCrossRefRepo: TuningSystemNoteRepository
) {
    suspend fun createTuningSystem(tuningSystem: TuningSystem, tunSysParams:List<TunSysParameter>) {
        //check if tunSys exists
        val tunSysId = findMatchingTunSys(tuningSystem,tunSysParams)?: tunSysRepo.insertTuningSystem(tuningSystem)
        tunSysParams.forEach {
            it.tunSysId = tunSysId
            // TODO it.valueType = inferValueType(it.value)
            tunSysParamRepo.insertTunSysParameter(it)
        }
        val notes = generateNotes(tunSysRepo.getTuningSystemWithParameters(tunSysId))
        val notesIds = noteRepo.insertAllNotes(notes)
        notesIds.forEach {
            val reference = TuningSystemNote(tunSysId, it,"","","")
            tunSysNoteCrossRefRepo.insertTunSysNoteCrossRef(reference)
            //TODO they must define their names and etc
        }
    }

    suspend fun deleteTuningSystem(tuningSystemId:Long):Boolean{
        return if (canDeleteTunSys(tuningSystemId)){
            tunSysRepo.deleteTuningSystemById(tuningSystemId)
            true
        } else {
            false
        }
    }

    suspend fun findMatchingTunSys(newTunSys: TuningSystem, newParams: List<TunSysParameter>): Long? {
        val candidates = tunSysRepo.getByAlgorithmAndBaseFrequency(
            newTunSys.algorithm,
            newTunSys.baseFrequency)
        if (!candidates.isEmpty()) {
            for (candidate in candidates) {
                val candidateParams = candidate?.let { tunSysRepo.getTuningSystemWithParameters(it.tunSysId) }?.tunSysParams
                if (candidateParams?.size == newParams.size &&
                    candidateParams.all { cp ->
                        newParams.any { np ->
                            np.valueType == cp.valueType &&
                                    np.valueName == cp.valueName &&
                                    np.value == cp.value
                        }
                    }
                ) {
                    return candidate.tunSysId // Found exact match
                }
            }
        }
        return null // No match
    }
    suspend fun canDeleteTunSys(tunSysId: Long): Boolean {
        val tunSysWithInstruments = tunSysRepo.getTuningSystemWithInstruments(tunSysId) ?: return false
        return !tunSysWithInstruments.tuningSystem.default && tunSysWithInstruments.instruments.isEmpty()
    }

    private fun generateNotes(tuningSystem: TuningSystemWithParameters?):List<Note>

    {
        //TODO
        return listOf(
            Note(0L, 440.0, 4),
            Note(1L, 493.88, 4)
        )
    }
}