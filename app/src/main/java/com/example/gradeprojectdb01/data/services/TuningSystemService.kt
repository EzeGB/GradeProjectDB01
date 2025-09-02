package com.example.gradeprojectdb01.data.services

import androidx.room.Transaction
import com.example.gradeprojectdb01.data.convertersAndEnums.ParamValType
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

    @Transaction
    suspend fun createTuningSystem(tuningSystem: TuningSystem, tunSysParams:List<TunSysParameter>) :Long{
        //check if tunSys exists
        val existingTunSysId = findMatchingTunSys(tuningSystem,tunSysParams)
        if (existingTunSysId!=null)
            return existingTunSysId
        //if this tuning system doesn't exist, create a new one and attach parts to it
        else {
            val newTunSysId = tunSysRepo.insertTuningSystem(tuningSystem)
            tunSysParams.forEach {
                it.tunSysId = newTunSysId
                it.valueType = ParamValType.inferValueType(it.value)
                tunSysParamRepo.insertTunSysParameter(it)
            }
            val generatedNotes = generateNotes(tunSysRepo.getTuningSystemWithParameters(newTunSysId))
            val notesIds = noteRepo.insertAllNotes(deduplicateNotes(generatedNotes))
            notesIds.forEach {
                val reference = TuningSystemNote(newTunSysId, it, "", "", "")
                tunSysNoteCrossRefRepo.insertTunSysNoteCrossRef(reference)
                //TODO they must define their names and etc
            }
            return newTunSysId
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

    private suspend fun findMatchingTunSys(newTunSys: TuningSystem, newParams: List<TunSysParameter>): Long? {
        //finds tuning systems with same values
        val candidates = tunSysRepo.getByAlgorithmAndBaseFrequency(
            newTunSys.algorithm,
            newTunSys.baseFrequency)

        if (!candidates.isEmpty()) {
            //each of the candidates gets it's parameters analyzed
            for (candidate in candidates) {
                val candidateParams = tunSysRepo.getExistingTuningSystemWithParameters(
                    candidate.tunSysId).tunSysParams

                //the parameters in the new one must be exactly the same of the candidate to be a match
                if (candidateParams.size == newParams.size &&
                    candidateParams.all { canParam ->
                        //all of the candidate parameters must match exactly with any of the new parameters
                        newParams.any { newParam ->
                            newParam.valueType == canParam.valueType &&
                                    newParam.valueName == canParam.valueName &&
                                    newParam.value == canParam.value
                        }
                    }
                ) {
                    return candidate.tunSysId // Found exact match
                }
            }
        }
        return null // No match
    }
    private suspend fun canDeleteTunSys(tunSysId: Long): Boolean {
        val tunSysWithInstruments = tunSysRepo.getTuningSystemWithInstruments(tunSysId) ?: return false
        return !tunSysWithInstruments.tuningSystem.default && tunSysWithInstruments.instruments.isEmpty()
    }
    private fun generateNotes(tuningSystem: TuningSystemWithParameters?):List<Note> {
        //TODO
        return listOf(
            Note(0L, 440.0),
            Note(1L, 493.88)
        )
    }
    private suspend fun deduplicateNotes(generatedNotes: List<Note>): List<Note>{
        //I fetch all notes from DB and map them by Frequency
        val existingNotesByFrequency= noteRepo.getAllNotes().associateBy { it.frequency }

        //It checks if freq of genNotes already exists in DB. If it's the case
        //The returned list will contain existing notes id's, which will just be replaced
        //With all fields intact and old ID
        return generatedNotes.map { genNote ->
            val alreadyExists = existingNotesByFrequency[genNote.frequency]
            if (alreadyExists !=null)
                genNote.copy(noteId = alreadyExists.noteId)
            else
                genNote
        }
    }
}