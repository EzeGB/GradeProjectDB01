package com.example.gradeprojectdb01.data.repositories

import com.example.gradeprojectdb01.data.daos.InstrumentNoteDao
import com.example.gradeprojectdb01.data.entities.InstrumentNote

class InstrumentNoteRepository(
    private val instrumentNoteDao: InstrumentNoteDao
) {

    // CREATE
    suspend fun insertInstNoteCrossRef(instNoteCrossRef: InstrumentNote) {
        instrumentNoteDao.insertInstNoteCrossRef(instNoteCrossRef)
    }

    suspend fun insertAllInstNoteCrossRefs(instNoteCrossRefs: List<InstrumentNote>) {
        instrumentNoteDao.insertAllInstNoteCrossRefs(instNoteCrossRefs)
    }

    //UPDATE
    suspend fun updateNoteName(instrumentId: Long, noteId: Long, name: String) {
        instrumentNoteDao.updateNoteName(noteId, instrumentId, name)
    }

    suspend fun updateNoteAlteration(instrumentId: Long, noteId: Long, alteration: String) {
        instrumentNoteDao.updateNoteAlteration(noteId, instrumentId, alteration)
    }

    // DELETE
    suspend fun deleteInstNoteCrossRef(instNoteCrossRef: InstrumentNote) {
        instrumentNoteDao.deleteInstNoteCrossRef(instNoteCrossRef)
    }

    suspend fun deleteInstNoteCrossRefs(instNoteCrossRefs: List<InstrumentNote>) {
        instrumentNoteDao.deleteInstNoteCrossRefs(instNoteCrossRefs)
    }

    suspend fun deleteInstNoteCrossRefByIds(instrumentId: Long, noteId: Long) {
        instrumentNoteDao.deleteInstNoteCrossRefByIds(instrumentId, noteId)
    }

    suspend fun deleteAllInstNoteCrossRefByInstrumentId(instrumentId: Long) {
        instrumentNoteDao.deleteAllInstNoteCrossRefByInstrumentId(instrumentId)
    }

    suspend fun deleteAllInstNoteCrossRefByNoteId(noteId: Long) {
        instrumentNoteDao.deleteAllInstNoteCrossRefByNoteId(noteId)
    }

    suspend fun deleteAllInstNoteCrossRefs() {
        instrumentNoteDao.deleteAllInstNoteCrossRefs()
    }
}