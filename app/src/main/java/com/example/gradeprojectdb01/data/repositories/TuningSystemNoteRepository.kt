package com.example.gradeprojectdb01.data.repositories

import com.example.gradeprojectdb01.data.daos.TuningSystemNoteDao
import com.example.gradeprojectdb01.data.entities.TuningSystemNote

class TuningSystemNoteRepository(
    private val tuningSystemNoteDao: TuningSystemNoteDao
) {

    // CREATE
    suspend fun insertTunSysNoteCrossRef(tunSysNoteCrossRef: TuningSystemNote) {
        tuningSystemNoteDao.insertTunSysNoteCrossRef(tunSysNoteCrossRef)
    }

    suspend fun insertAllTunSysNoteCrossRefs(tunSysNoteCrossRefs: List<TuningSystemNote>) {
        tuningSystemNoteDao.insertAllTunSysNoteCrossRefs(tunSysNoteCrossRefs)
    }

    //UPDATE
    suspend fun updateNoteName(tunSysId: Long, noteId: Long, name: String) {
        tuningSystemNoteDao.updateNoteName(noteId, tunSysId, name)
    }

    suspend fun updateNoteAlteration(tunSysId: Long, noteId: Long, alteration: String) {
        tuningSystemNoteDao.updateNoteAlteration(noteId, tunSysId, alteration)
    }

    // DELETE
    suspend fun deleteTunSysNoteCrossRef(tunSysNoteCrossRef: TuningSystemNote) {
        tuningSystemNoteDao.deleteTunSysNoteCrossRef(tunSysNoteCrossRef)
    }

    suspend fun deleteTunSysNoteCrossRefs(tunSysNoteCrossRefs: List<TuningSystemNote>) {
        tuningSystemNoteDao.deleteTunSysNoteCrossRefs(tunSysNoteCrossRefs)
    }

    suspend fun deleteTunSysNoteCrossRefByIds(tunSysId: Long, noteId: Long) {
        tuningSystemNoteDao.deleteTunSysNoteCrossRefByIds(tunSysId, noteId)
    }

    suspend fun deleteAllTunSysNoteCrossRefByTunSysId(tunSysId: Long) {
        tuningSystemNoteDao.deleteAllTunSysNoteCrossRefByTunSysId(tunSysId)
    }

    suspend fun deleteAllTunSysNoteCrossRefByNoteId(noteId: Long) {
        tuningSystemNoteDao.deleteAllTunSysNoteCrossRefByNoteId(noteId)
    }

    suspend fun deleteAllTunSysNoteCrossRefs() {
        tuningSystemNoteDao.deleteAllTunSysNoteCrossRefs()
    }
}
