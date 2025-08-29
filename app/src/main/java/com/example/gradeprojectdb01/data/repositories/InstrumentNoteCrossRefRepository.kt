package com.example.gradeprojectdb01.data.repositories

import com.example.gradeprojectdb01.data.daos.InstrumentNoteCrossRefDao
import com.example.gradeprojectdb01.data.entities.InstrumentNoteCrossRef

class InstrumentNoteCrossRefRepository(
    private val instrumentNoteCrossRefDao: InstrumentNoteCrossRefDao
) {

    // CREATE
    suspend fun insertInstNoteCrossRef(instNoteCrossRef: InstrumentNoteCrossRef) {
        instrumentNoteCrossRefDao.insertInstNoteCrossRef(instNoteCrossRef)
    }

    suspend fun insertAllInstNoteCrossRefs(instNoteCrossRefs: List<InstrumentNoteCrossRef>) {
        instrumentNoteCrossRefDao.insertAllInstNoteCrossRefs(instNoteCrossRefs)
    }

    // DELETE
    suspend fun deleteInstNoteCrossRef(instNoteCrossRef: InstrumentNoteCrossRef) {
        instrumentNoteCrossRefDao.deleteInstNoteCrossRef(instNoteCrossRef)
    }

    suspend fun deleteInstNoteCrossRefs(instNoteCrossRefs: List<InstrumentNoteCrossRef>) {
        instrumentNoteCrossRefDao.deleteInstNoteCrossRefs(instNoteCrossRefs)
    }

    suspend fun deleteInstNoteCrossRefByIds(instrumentId: Long, noteId: Long) {
        instrumentNoteCrossRefDao.deleteInstNoteCrossRefByIds(instrumentId, noteId)
    }

    suspend fun deleteAllInstNoteCrossRefByInstrumentId(instrumentId: Long) {
        instrumentNoteCrossRefDao.deleteAllInstNoteCrossRefByInstrumentId(instrumentId)
    }

    suspend fun deleteAllInstNoteCrossRefByNoteId(noteId: Long) {
        instrumentNoteCrossRefDao.deleteAllInstNoteCrossRefByNoteId(noteId)
    }

    suspend fun deleteAllInstNoteCrossRefs() {
        instrumentNoteCrossRefDao.deleteAllInstNoteCrossRefs()
    }
}